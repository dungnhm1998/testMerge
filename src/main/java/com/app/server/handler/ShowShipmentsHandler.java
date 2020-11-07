package com.app.server.handler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.app.models.ClipServices;
import com.app.pojo.Shipments;
import com.app.pojo.Users;
import com.app.session.redis.SessionStore;
import com.app.util.AppParams;
import com.app.util.PageBean;
import com.google.gson.Gson;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.rxjava.core.http.HttpServerRequest;
import io.vertx.rxjava.ext.web.Cookie;
import io.vertx.rxjava.ext.web.RoutingContext;

public class ShowShipmentsHandler implements Handler<RoutingContext>, SessionStore {
	static ClipServices clipServices;

	@Override
	public void handle(RoutingContext routingContext) {
		routingContext.vertx().executeBlocking(future -> {
			try {
				HttpServerRequest httpServerRequest = routingContext.request();
				Cookie cookie = routingContext.getCookie("sessionId"); // Gọi cookie
				String dateFrom = httpServerRequest.getParam("dateFrom");
				String dateTo = httpServerRequest.getParam("dateTo");
				String trackingCode = httpServerRequest.getParam("trackingCode");
				String pageString = httpServerRequest.getParam("page");
				String pageSizeString = httpServerRequest.getParam("pageSize");
				int page = 1;
				int pageSize = 10;
				if (pageString != null && pageSizeString != null && pageString != "" && pageSizeString != "") {
					page = Integer.parseInt(pageString);
					pageSize = Integer.parseInt(pageSizeString);
				} else {
					page = 1;
					pageSize = 10;
				}
				Gson gson = new Gson();
				JsonObject data = new JsonObject();

				String sessionId = cookie.getValue(); // Lấy sessionId từ cookie
				Users loggedInUser = gson.fromJson(jedis.get(sessionId), Users.class); // Lấy dữ liệu từ redis

				String email = loggedInUser.getEmail();

				// tìm shipments theo email
				List<Shipments> list;

				if (dateFrom == "" && dateTo == "") {
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					dateFrom = dateFormat.format(dateFormat.parse("2000-01-01 00:00:00"));
					dateTo = dateFormat.format(new Date());
				}

				long totalEntry = getTotalEntry(email, dateFrom, dateTo, trackingCode);

				if (totalEntry > 0) {

					list = getShipments(email, trackingCode, dateFrom, dateTo, page, pageSize);

					data.put("message", "list Shipments");
					data.put("totalEntry", totalEntry);
					data.put("list", list);
					routingContext.put(AppParams.RESPONSE_CODE, HttpResponseStatus.OK.code());
					routingContext.put(AppParams.RESPONSE_MSG, HttpResponseStatus.OK.reasonPhrase());
				} else {
					data.put("message", "error");
					data.put("totalEntry", totalEntry);
					data.put("list", " ");

					routingContext.put(AppParams.RESPONSE_CODE, HttpResponseStatus.BAD_REQUEST.code());
					routingContext.put(AppParams.RESPONSE_MSG, HttpResponseStatus.BAD_REQUEST.reasonPhrase());
				}
				routingContext.put(AppParams.RESPONSE_DATA, data);
				future.complete();
			} catch (Exception e) {
				routingContext.fail(e);
			}
		}, asyncResult -> {
			if (asyncResult.succeeded()) {
				routingContext.next();
			} else {
				routingContext.fail(asyncResult.cause());
			}
		});
	}

	@SuppressWarnings("unchecked")
	public static long getTotalEntry(String email, String dateFrom, String dateTo, String trackingCode) {
		long rs = 0;
		List<Long> count = null;
		try {
			if (trackingCode == null) {
				trackingCode = "";
			}
			count = clipServices.findAllByProperty(
					"select count(id) FROM Shipments WHERE (created_by = '" + email + "') AND (tracking_code LIKE '%"
							+ trackingCode + "%') AND (created_at BETWEEN '" + dateFrom + "' AND '" + dateTo + "')",
					null, 0, Shipments.class, 0);
			if (count.size() > 0) {
				rs = count.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@SuppressWarnings("unchecked")
	public static List<Shipments> getShipments(String email, String dateFrom, String dateTo, int page, int pageSize) {
		List<Shipments> list = null;
		try {
			PageBean pageBean = new PageBean();
			pageBean.setPage(page);
			pageBean.setPageSize(pageSize);
			list = clipServices.findAllByProperty("FROM Shipments WHERE (created_by = '" + email
					+ "') AND (created_at BETWEEN '" + dateFrom + "' AND '" + dateTo + "')", pageBean, 0,
					Shipments.class, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static List<Shipments> getShipments(String email, String trackingCode, String dateFrom, String dateTo,
			int page, int pageSize) {
		List<Shipments> list = null;
		try {
			PageBean pageBean = new PageBean();
			pageBean.setPage(page);
			pageBean.setPageSize(pageSize);
			list = clipServices.findAllByProperty(
					"FROM Shipments WHERE (created_by = '" + email + "') AND (tracking_code LIKE '%" + trackingCode
							+ "%') AND (created_at BETWEEN '" + dateFrom + "' AND '" + dateTo + "')",
					pageBean, 0, Shipments.class, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void setClipServices(ClipServices clipServices) {
		ShowShipmentsHandler.clipServices = clipServices;
	}

}
