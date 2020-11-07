package com.app.server.handler;

import com.app.models.ClipServices;
import com.app.pojo.Users;
import com.app.session.redis.SessionStore;
import com.app.util.AppParams;
import com.google.gson.Gson;

import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.rxjava.core.http.HttpServerRequest;
import io.vertx.rxjava.ext.web.RoutingContext;

public class DetailShipmentsHandler implements Handler<RoutingContext>, SessionStore {
	static ClipServices clipServices;

	@Override
	public void handle(RoutingContext routingContext) {
		routingContext.vertx().executeBlocking(future -> {
			try {
				Gson gson = new Gson();
				HttpServerRequest httpServerRequest = routingContext.request();
				String sessionId = httpServerRequest.getParam("sessionId");
				Users loggedInUser2 = gson.fromJson(jedis.get(sessionId), Users.class);
				JsonObject data = new JsonObject();

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

	public static void setClipServices(ClipServices clipServices) {
		DetailShipmentsHandler.clipServices = clipServices;
	}

}
