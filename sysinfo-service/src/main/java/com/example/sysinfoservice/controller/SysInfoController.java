package com.example.sysinfoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

@RestController
@RequestMapping("/os")
public class SysInfoController {

    @GetMapping("/info")
    public String getOsInfo() {
        String osType = System.getProperty("os.name");
        String hostName = "";
        String ipAddress = "";
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            hostName = localHost.getHostName();
            ipAddress = localHost.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "{ \"osType\": \"" + osType + "\", \"hostName\": \"" + hostName + "\", \"ipAddress\": \"" + ipAddress + "\" }";
    }

    @GetMapping("/status")
    public String getOsStatus() {
        OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        double cpuUsage = osBean.getSystemCpuLoad() * 100;
        double memoryUsage = (1 - (double) osBean.getFreePhysicalMemorySize() / osBean.getTotalPhysicalMemorySize()) * 100;

        return "{ \"cpuUsage\": \"" + cpuUsage + "%\", \"memoryUsage\": \"" + memoryUsage + "%\" }";
    }

}
