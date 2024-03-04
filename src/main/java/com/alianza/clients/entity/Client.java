package com.alianza.clients.entity;

public class Client {

    private String shared_key;
    private String name;
    private String email;
    private Long phone;
    private String data_added;
    private String start_date;
    private String end_date;

    public Client() {

    }

    public Client(String name, String email, Long phone,String start_date, String end_date) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.start_date = start_date;
        this.end_date = end_date;
    }
    public Client(String shared_key, String name, String email, Long phone, String data_added, String start_date, String end_date) {
        this.shared_key = shared_key;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.data_added = data_added;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getShared_key() {
        return shared_key;
    }

    public void setShared_key(String shared_key) {
        this.shared_key = shared_key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getData_added() {
        return data_added;
    }

    public void setData_added(String data_added) {
        this.data_added = data_added;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Client{" +
                "shared_key='" + shared_key + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", data_added='" + data_added + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                '}';
    }
}
