package br.com.slloww.sa.DTOs;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.slloww.sa.entities.Order;

public class OrderDTO implements Serializable {
		private static final long serialVersionUID = 1L;

		private Long id;
		private LocalDateTime date;
		private String customer_name;
		private String seller_name;
		private Long customer_id;
		private Long seller_id;

		public OrderDTO() {
		}

		public OrderDTO(Order order) {
			super();
			this.id = order.getId();
			this.date = order.getDate();
			this.customer_name = order.getCustomer().getName();
			this.seller_name = order.getSeller().getName();
			this.customer_id = order.getCustomer().getId();
			this.seller_id = order.getSeller().getId();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getData() {
			return date;
		}

		public void setData(LocalDateTime date) {
			this.date = date;
		}

		public String getCustomer_name() {
			return customer_name;
		}

		public void setCustomer_name(String customer_name) {
			this.customer_name = customer_name;
		}

		public String getSeller_name() {
			return seller_name;
		}

		public void setSeller_name(String seller_name) {
			this.seller_name = seller_name;
		}

		public Long getCustomer_id() {
			return customer_id;
		}

		public void setCustomer_id(Long customer_id) {
			this.customer_id = customer_id;
		}

		public Long getSeller_id() {
			return seller_id;
		}

		public void setSeller_id(Long seller_id) {
			this.seller_id = seller_id;
		}
}
