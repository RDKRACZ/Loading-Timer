package io.github.blobanium.lt.config;

import io.github.blobanium.lt.LoadingTimer;

public class ConfigReader {
    public static boolean rawLoadingToast = false;
    public static boolean resourceLoadNotifStartupOverride = false;
    public static boolean resourceLoadNotif = false;
    public static boolean resourceLoadPercent = false;
    public static boolean insanePrecision = false;
    public static boolean worldLoadTime = false;
    public static boolean noException = false;

    public static void configRegister(){
    	LoadingTimer.LOGGER.debug("Registering config..");
    	SimpleConfig CONFIG = SimpleConfig.of("LoadingTimer").provider(namespace -> ConfigReader.ltProvider(namespace)).request();
    	final boolean insanePrecisionConfig = CONFIG.getOrDefault("insane_precision", false); 
    	final boolean noExceptionConfig = CONFIG.getOrDefault("no_exception", false);
    	final boolean worldLoadTimeConfig = CONFIG.getOrDefault("world_loading_timer", false);
    	final boolean resourceLoadPercentConfig = CONFIG.getOrDefault("show_resource_load_percent", false);
    	final boolean resourceLoadNotifConfig = CONFIG.getOrDefault("resource_loading_notification", false);
    	final boolean resourceLoadNotifStartupOverrideConfig = CONFIG.getOrDefault("resource_loading_notif_override", false);
    	final boolean rawLoadingToastConfig = CONFIG.getOrDefault("raw_loading_toast", false);
    	if (insanePrecisionConfig) {
    		LoadingTimer.LOGGER.debug("Insane Precision is on");
    		LoadingTimer.STARTINGTIME2 = LoadingTimer.startingTimeNano;
    		insanePrecision = true;
    	}
    	if(noExceptionConfig){
    		noException = true;
    	}
    	if(worldLoadTimeConfig){
    		worldLoadTime = true;
    	}
    	if(resourceLoadPercentConfig){
    		resourceLoadPercent = true;
    	}
    	if(resourceLoadNotifConfig){
    		resourceLoadNotif = true;
    	}
    	if(resourceLoadNotifStartupOverrideConfig){
    		resourceLoadNotifStartupOverride = true;
    		if(!resourceLoadNotif){
    			LoadingTimer.LOGGER.warn("the resource_loading_notif_override config won't work unless resource_loading_notification is set to true!!");
    		}
    	}
    	if(rawLoadingToastConfig){
    		rawLoadingToast = true;
    	}
    }

    public static String ltProvider(String filename) {
    	return "#Loading timer Config File. For more details on what these options do, go to https://github.com/Blobanium/Loading-Timer/wiki/Config-Guide."
    	+ "\ninsane_precision=false"
    	+ "\nno_exception=false"
    	+ "\nworld_loading_timer=false"
    	+ "\nshow_resource_load_percent=false"
    	+ "\nresource_loading_notification=false"
    	+ "\nresource_loading_notif_override=false"
    	+ "\nraw_loading_toast=false";
    }
    
}
