package de.hsos.control.management;

import de.hsos.control.crud.IOrderingCrud;
import de.hsos.control.service.OrderingService;
import de.hsos.shared.dto.DeleteOrderPositionDTO;
import de.hsos.shared.dto.OrderPositionDTO;
import de.hsos.shared.dto.OrderingDTO;
import de.hsos.shared.dto.OrderingGetDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class OrderingManagement implements IOrderingCrud {


    @Inject
    OrderingService orderingService;

    @Override
    public OrderingGetDTO getOrder(Long id) {
        return null;
    }

    @Override
    public OrderingGetDTO getCurrentOrder(Long customerId) {
        return this.orderingService.getCurrentOrder(customerId);
    }

    @Override
    public boolean createOrderPosition(Long id, OrderPositionDTO orderPositionDTO) {
        return this.orderingService.createOrderPosition(id, orderPositionDTO);
    }


    @Override
    public boolean updateOrderPosition(Long id, OrderPositionDTO orderPositionDTO) {
        return this.orderingService.updateOrderPosition(id, orderPositionDTO);
    }

    @Override
    public boolean deleteOrderPosition(Long id, DeleteOrderPositionDTO deleteOrderPositionDTO) {
        return this.orderingService.deleteOrderPosition(id, deleteOrderPositionDTO);
    }

    @Override
    public boolean submitOrder(Long id) {
        return this.orderingService.submitOrder(id);
    }


}
