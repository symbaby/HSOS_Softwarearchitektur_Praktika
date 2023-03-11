package de.hsos.gateway;

import de.hsos.entity.Customer;
import de.hsos.entity.catalogues.IOrderingCatalogue;
import de.hsos.entity.OrderPosition;
import de.hsos.entity.Ordering;
import de.hsos.entity.Pizza;
import de.hsos.shared.dto.*;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

@RequestScoped
public class OrderingRepository implements IOrderingCatalogue, PanacheRepository<Ordering> {


    @Override
    @Transactional
    public OrderingGetDTO getOrder(Long id) {
        return DTOConverter.toOrderingGetDTO(findById(id));
    }

    @Override
    @Transactional
    public OrderingGetDTO getCurrentOrder(Long customerId) {

        Customer customer = Customer.findById(customerId);
        return DTOConverter.toOrderingGetDTO(customer.getCurrentOrder());
    }


    @Override
    @Transactional
    public boolean createOrderPosition(Long id, OrderPositionDTO orderPositionDTO) {

        Customer customer = Customer.findCustomer(id);

        if (customer != null) {
            Pizza pizza = Pizza.findById(orderPositionDTO.pizzaId);
            OrderPosition orderPosition = new OrderPosition(pizza, orderPositionDTO.quantity);
            orderPosition.persist();


            customer.getCurrentOrder().getOrderPositionList().add(orderPosition);
            customer.persist();

            return true;
        }

        return false;
    }


    @Override
    @Transactional
    public boolean updateOrderPosition(Long id, OrderPositionDTO orderPositionDTO) {

        Customer customer = Customer.findCustomer(id);

        // Size ist ok aber wir iterieren wie husos
        System.out.println(customer.getCurrentOrder().getOrderPositionList().size());

        if (customer != null) {
            for (OrderPosition orderPosition : customer.getCurrentOrder().getOrderPositionList()) {
                if (orderPosition.getPizza().getId() == orderPositionDTO.pizzaId) {
                    orderPosition.setQty(orderPositionDTO.quantity);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteOrderPosition(Long id, DeleteOrderPositionDTO deleteOrderPositionDTO) {

        Customer customer = Customer.findCustomer(id);

        if (customer != null) {
            for (int i = 0; i < customer.getCurrentOrder().getOrderPositionList().size(); i++) {
                if (customer.getCurrentOrder().getOrderPositionList().get(i).getPizza().getId() == deleteOrderPositionDTO.pizzaId) {
                    customer.getCurrentOrder().getOrderPositionList().remove(i);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean submitOrder(Long id) {

        Customer customer = Customer.findCustomer(id);
        if (customer != null) {
            customer.getCurrentOrder().getOrderPositionList().clear();
            // SubmitOrderDTO bereitstellen
            return true;
        }
        return false;
    }

}
