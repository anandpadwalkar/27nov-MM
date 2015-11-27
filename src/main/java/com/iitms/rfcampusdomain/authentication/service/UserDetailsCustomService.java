package com.iitms.rfcampusdomain.authentication.service;

import java.util.List;

public interface UserDetailsCustomService {

    public List<Integer> getRoleIdsByUser(String username);
}
