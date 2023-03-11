package de.hsos.shared.dto;

import de.hsos.entity.Customer;
import de.hsos.entity.OrderPosition;
import de.hsos.entity.Ordering;
import de.hsos.entity.Pizza;

import java.util.ArrayList;
import java.util.List;

public class DTOConverter {

    public static CustomerDTO toCustomerDTO(Customer customer) {

        return new CustomerDTO(customer.getName(), customer.getAddress());
    }


    public static CustomerGetDTO toCustomerGetDTO(Customer customer) {

        return new CustomerGetDTO(customer.getName(), customer.getAddress(), DTOConverter.toOrderingGetDTO(customer.getCurrentOrder()), customer.getId());
    }

    private static OrderingDTO toOrderingDTO(Ordering ordering) {
        List<OrderPositionDTO> dtoList = new ArrayList<>();

        for (OrderPosition o : ordering.getOrderPositionList()) {
            dtoList.add(DTOConverter.toOrderPositionDTO(o));
        }

        return new OrderingDTO(dtoList);
    }

    private static OrderPositionDTO toOrderPositionDTO(OrderPosition orderPosition) {
        return new OrderPositionDTO(orderPosition.getPizza().getId(), orderPosition.getQty(), orderPosition.getPizza().getName());
    }

    private static PizzaDTO toPizzaDTO(Pizza pizza) {
        return new PizzaDTO(pizza.getId(), pizza.getName(), pizza.getPrice());
    }

    public static Customer fromCustomerDTO(CustomerDTO customerDTO) {
        return new Customer(customerDTO.name, customerDTO.address);
    }

    public static Customer fromCustomerGetDTO(CustomerGetDTO customerGetDTO) {
        return new Customer(customerGetDTO.name, customerGetDTO.address);
    }

    public static OrderingGetDTO toOrderingGetDTO(Ordering o) {
        List<OrderPositionDTO> dtoList = new ArrayList<>();

        for (OrderPosition orig : o.getOrderPositionList()) {
            dtoList.add(new OrderPositionDTO(orig.getPizza().getId(), orig.getQty(), orig.getPizza().getName()));
        }

        return new OrderingGetDTO(dtoList);
    }

    public static Ordering fromOrderingDTO(OrderingDTO orderingDTO) {
        List<OrderPosition> orderPositionList = new ArrayList<>();

        for (OrderPositionDTO o : orderingDTO.orderPositionList) {
            Pizza p = Pizza.findById(o.pizzaId);

            orderPositionList.add(new OrderPosition(p, o.quantity));
        }

        return new Ordering(orderPositionList);
    }


}
