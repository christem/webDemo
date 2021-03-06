package org.smart4j.chapter2.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;

/**
 * 进入 客户列表 界面
 */
@WebServlet("/org/smart4j/chapter2/controller/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customerList = customerService.getCustomerList();
//        List<Customer> customerList = customerService.getJdbcCustomerList();
        req.setAttribute("customerList", customerList);
        req.getRequestDispatcher("/WEB-INF/jsp/org/smart4j/chapter2/customer.jsp").forward(req, resp);
    }
}
