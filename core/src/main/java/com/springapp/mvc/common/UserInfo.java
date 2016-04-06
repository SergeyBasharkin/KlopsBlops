package com.springapp.mvc.common;

import javax.persistence.*;

/**
 * Gataullin Kamil
 * 28.03.2016 20:58
 */
@Entity
@Table(name = "h_users")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * ФИО пользователя
     */
    private String fio;

    /**
     * Логин пользователя для входа на сайт, он же email
     */
    private String login;

    /**
     * hash пароля пользователя
     */
    private String hashPassword;

    /**
     * Права доступа пользователя (возможные значения 'ROLE_USER', 'ROLE_ADMIN')
     */
    private String role;

    /**
     * Уникальный ключ для подтверждения пользователя, отправляется по почте
     */
    private String key;

    /**
     * Флаг, что пользователь подтвержден и активен.
     */
    private Boolean enabled;

    public UserInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
