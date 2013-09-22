package org.atinject.api.user.dto;

import org.atinject.core.dto.DTO;

public class User extends DTO {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public User()
    {
        super();
    }

    public String getId()
    {
        return id;
    }

    public User setId(String id)
    {
        this.id = id;
        return this;
    }

    public String getName()
    {
        return name;
    }

    public User setName(String name)
    {
        this.name = name;
        return this;
    }

}
