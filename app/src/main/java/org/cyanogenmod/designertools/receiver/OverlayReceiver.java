package org.cyanogenmod.designertools.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.cyanogenmod.designertools.overlays.ColorPickerOverlay;
import org.cyanogenmod.designertools.overlays.GridOverlay;
import org.cyanogenmod.designertools.overlays.MockOverlay;

public class OverlayReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) return;
        String action = intent.getAction();

        switch (action) {
            case "com.scheffsblend.designertools.action.SHOW_GRID_OVERLAY":
                context.startService(new Intent(context, GridOverlay.class));
                break;
            case "com.scheffsblend.designertools.action.HIDE_GRID_OVERLAY":
                context.stopService(new Intent(context, GridOverlay.class));
                break;

            case "com.scheffsblend.designertools.action.SHOW_MOCK_OVERLAY":
                context.startService(new Intent(context, MockOverlay.class));
                break;
            case "com.scheffsblend.designertools.action.HIDE_MOCK_OVERLAY":
                context.stopService(new Intent(context, MockOverlay.class));
                break;

            case "com.scheffsblend.designertools.action.SHOW_COLOR_PICKER_OVERLAY":
                context.startService(new Intent(context, ColorPickerOverlay.class));
                break;
            case "com.scheffsblend.designertools.action.HIDE_COLOR_PICKER_OVERLAY":
                context.stopService(new Intent(context, ColorPickerOverlay.class));
                break;

            default:
                break;
        }
    }
}
