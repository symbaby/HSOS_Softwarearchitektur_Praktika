package de.hsos.control.service;

import de.hsos.control.crud.IOrderingCrud;
import de.hsos.gateway.OrderingRepository;
import de.hsos.shared.dto.DeleteOrderPositionDTO;
import de.hsos.shared.dto.OrderPositionDTO;
import de.hsos.shared.dto.OrderingGetDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class OrderingService implements IOrderingCrud {


    @Inject
    OrderingRepository orderingRepository;


    @Override
    public OrderingGetDTO getOrder(Long id) {
        return this.orderingRepository.getOrder(id);
    }

    @Override
    public OrderingGetDTO getCurrentOrder(Long customerId) {
        return this.orderingRepository.getCurrentOrder(customerId);
    }


    @Override
    public boolean createOrderPosition(Long id, OrderPositionDTO orderPositionDTO) {
        return this.orderingRepository.createOrderPosition(id, orderPositionDTO);
    }

    @Override
    public boolean updateOrderPosition(Long id, OrderPositionDTO orderPositionDTO) {
        return this.orderingRepository.updateOrderPosition(id, orderPositionDTO);
    }

    @Override
    public boolean deleteOrderPosition(Long id, DeleteOrderPositionDTO deleteOrderPositionDTO) {
        return this.orderingRepository.deleteOrderPosition(id, deleteOrderPositionDTO);
    }

    @Override
    public boolean submitOrder(Long id) {
        return this.orderingRepository.submitOrder(id);
    }


}
