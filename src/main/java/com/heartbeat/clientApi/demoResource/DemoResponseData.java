package com.heartbeat.clientApi.demoResource;

import com.heartbeat.clientApi.vo.BaseServiceResponse;

/**
 * Created by michaelkellstrand on 1/5/17.
 */
public class DemoResponseData extends BaseServiceResponse
{
    private String username;
    private String var1;
    private String var2;

    public DemoResponseData() {
    }

    public DemoResponseData(String username, String var1, String var2) {
        this.username = username;
        this.var1 = var1;
        this.var2 = var2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }
}
