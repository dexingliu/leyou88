package com.leyou.item.bo;

import com.leyou.item.pojo.Spu;



/**
 * 这是一个扩展类，为了完成业务来添加的对象
 * 能使用SPU的属性
 */
public class SpuBo extends Spu{
    private String name;
    private String bname;
    private String cname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}