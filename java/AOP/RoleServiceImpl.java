package test.AOP;

import javax.management.relation.Role;
public class RoleServiceImpl implements RoleService {

    @Override
    public void prinRole(test.AOP.Role role) {
        System.out.println(role.toString());
    }
}
