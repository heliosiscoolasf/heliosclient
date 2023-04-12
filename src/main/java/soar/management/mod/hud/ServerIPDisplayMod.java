package soar.management.mod.hud;

import soar.management.event.EventTarget;
import soar.management.event.impl.EventRender2D;
import soar.management.mod.HUDMod;
import soar.utils.ServerUtils;

public final class ServerIPDisplayMod extends HUDMod{

	public ServerIPDisplayMod() {
		super("ServerIP Display");
	}

	@Override
	public void setup() {
		super.setupHUD();
	}

	@EventTarget
	public void onRender2D(EventRender2D event) {
		super.onRender2D();
	}

	@Override
	public String getText() {
		return ServerUtils.getServerIP();
	}
}
