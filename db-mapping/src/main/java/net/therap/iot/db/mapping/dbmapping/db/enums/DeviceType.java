package net.therap.iot.db.mapping.dbmapping.db.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duity
 * @since 5/10/22
 */

public enum DeviceType {

    SMART_PLUG("Smart Plug", "iot/smartPlug", "server/smartPlug", 0);

    public static final Map<DeviceType, String> nameMap = new HashMap<>();
    public static final Map<DeviceType, String> deviceTopicMap = new HashMap<>();
    public static final Map<DeviceType, String> serverTopicMap = new HashMap<>();
    public static final Map<DeviceType, Integer> qosMap = new HashMap<>();

    static {
        for (DeviceType d: values()) {
            nameMap.put(d, d.getName());
            deviceTopicMap.put(d, d.getDeviceTopicName());
            serverTopicMap.put(d, d.getServerTopicName());
            qosMap.put(d, d.getMqttQos());
        }
    }

    private String name;
    private String deviceTopicName;
    private String serverTopicName;
    private int mqttQos;

    DeviceType(String deviceName, String deviceTopicName, String serverTopicName, int mqttQos) {
        this.name = deviceName;
        this.deviceTopicName = deviceTopicName;
        this.serverTopicName = serverTopicName;
        this.mqttQos = mqttQos;
    }

    public String getName() {
        return this.name;
    }

    public String getDeviceTopicName() {
        return deviceTopicName;
    }

    public String getServerTopicName() {
        return serverTopicName;
    }

    public int getMqttQos() {
        return this.mqttQos;
    }

    public static String valueofName (DeviceType d) {
        return nameMap.get(d);
    }

    public static String valueofDeviceTopicName (DeviceType d) { return deviceTopicMap.get(d); }

    public static String valueofServerTopicName (DeviceType d) {
        return serverTopicMap.get(d);
    }

    public static int valueofQos (DeviceType d) {
        return qosMap.get(d);
    }

    public static DeviceType getDeviceType(String name) {
        for (DeviceType deviceType : values()) {
            if (deviceType.getName().equals(name)) {
                return deviceType;
            }
        }

        return null;
    }
}
