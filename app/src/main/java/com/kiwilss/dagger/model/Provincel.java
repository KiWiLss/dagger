package com.kiwilss.dagger.model;

/**
 * FileName: Provincel
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/31
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class Provincel {
    private String id;
    private String countryId;
    private String provinceName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "Provincel{" +
                "id='" + id + '\'' +
                ", countryId='" + countryId + '\'' +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
