package com.example.test1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableTransactionManagement  // 需要事务的时候加上
@RestController
public class PersonController {

    @Autowired
    private PersonMapper personMapper;

    @RequestMapping("/save")
    public Integer save() {
        User personDO = new User();
        personDO.setUsername("张三");
        personDO.setAge(18);
        personMapper.insert(personDO);
        return personDO.getId();
    }

    @RequestMapping("/update")
    public Long update() {
    	try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
        User personDO = new User();
        personDO.setId(2);
        personDO.setUsername("旺旺");
        personDO.setAge(12);
        return personMapper.update(personDO);
    }

    @RequestMapping("/delete")
    public Long delete() {
        return personMapper.delete(1);
    }

    @RequestMapping("/selectById")
    public User selectById() {
        return personMapper.selectById(2);
    }

    @RequestMapping("/selectAll")
    public List<User> selectAll() {
        return personMapper.selectAll();
    }

    @RequestMapping("/transaction")
    @Transactional  // 需要事务的时候加上
    public Boolean transaction() {
        delete();

        int i = 3 / 0;

        save();

        return true;
    }

}