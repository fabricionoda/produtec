package br.com.produtec.app.pedido.facade;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.produtec.app.pedido.Pedido;
import br.com.produtec.app.pedido.sequencial.SequencialPedidoRepository;

@Service
public class PedidoFacade {

	@Inject
	private SequencialPedidoRepository sequencialPedidoRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Pedido novoPedido() {
		Integer proximoNumeroDoPedido = sequencialPedidoRepository.getSequencialPedido().proximoNumeroDoPedido();
		return Pedido.newPedido(proximoNumeroDoPedido);
	}

}