package com.example.loginSystem.DAO;

import com.example.loginSystem.HibernateUtil;
import com.example.loginSystem.Model.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    Session session= HibernateUtil.getSessionFactory().openSession();
    @Override
    public List<User> findAll() {

        String query="SELECT * FROM users";
        SQLQuery sqlQuery=session.createSQLQuery(query);
        List<User[]> results= sqlQuery.getResultList();
        List<User> users=new ArrayList<>();
        for (Object[] rows:results)
        {
            User usr=getUserFromResults(rows);
            users.add(usr);
        }
        return users;
    }

    @Override
    public User findByID(int id) {

        String query="SELECT * FROM users WHERE id="+id;
        SQLQuery sqlQuery=session.createSQLQuery(query);
        List<User[]> results= sqlQuery.getResultList();
        for (Object[] rows:results)
        {
            User usr=getUserFromResults(rows);
            return usr;
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {

        String query="SELECT * FROM users WHERE username=\""+username+"\"";
        SQLQuery sqlQuery=session.createSQLQuery(query);
        List<User[]> results= sqlQuery.getResultList();
        for (Object[] rows:results)
        {
            User usr=getUserFromResults(rows);
            return usr;
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        Transaction transaction=session.beginTransaction();
        String query="INSERT INTO users VALUES(" +
                user.getId()+",\""+user.getUserName()+"\","+
                "\""+user.getPassword()+"\","+
                "\""+user.getName()+"\")";
        session.createSQLQuery(query).executeUpdate();
        session.getTransaction().commit();
        //session.close();
    }

    @Override
    public void modifyUserByID(User user, int id) {
        Transaction transaction=session.beginTransaction();
        String query="UPDATE users SET " +
                "username="+"\""+user.getUserName()+"\","+
                "password="+"\""+user.getPassword()+"\","+
                "name="+"\""+user.getName()+"\""+
                " WHERE id="+id;
        session.createSQLQuery(query).executeUpdate();
        session.getTransaction().commit();
        //session.close();

    }

    @Override
    public void modifyUserByUsername(User user, String username) {
        Transaction transaction=session.beginTransaction();
        String query="UPDATE users SET " +
                "username="+"\""+user.getUserName()+"\","+
                "password="+"\""+user.getPassword()+"\","+
                "name="+"\""+user.getName()+"\""+
                " WHERE username=\""+username+"\"";
        session.createSQLQuery(query).executeUpdate();
        session.getTransaction().commit();
        //session.close();

    }

    @Override
    public void deleteUserByID(int id) {
        Transaction transaction=session.beginTransaction();
        String query="DELETE FROM users WHERE id="+id;
        session.createSQLQuery(query).executeUpdate();
        session.getTransaction().commit();
        //session.close();

    }

    @Override
    public void deleteUserByUsername(String username) {
        Transaction transaction=session.beginTransaction();
        String query="DELETE FROM users WHERE username=\""+username+"\"";
        session.createSQLQuery(query).executeUpdate();
        session.getTransaction().commit();
        //session.close();

    }

    public User getUserFromResults(Object[] rows)
    {
        String str=rows[0].toString()+" "+rows[1].toString()+" "+rows[2].toString()+" "+rows[3].toString();
        String[] vals=str.split(" ");
        int num=0;
        for (char c:vals[0].toCharArray())
            num=(num*10)+((int)c-48);

        User usr=new User();
        usr.setId(num);
        usr.setName(vals[3]);
        usr.setUserName(vals[1]);
        usr.setPassword(vals[2]);
        return usr;

    }
}
