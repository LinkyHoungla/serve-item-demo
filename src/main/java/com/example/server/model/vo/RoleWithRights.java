package com.example.server.model.vo;

import com.example.server.model.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class RoleWithRights extends Role {
    private List<PageTree> rights;
}
