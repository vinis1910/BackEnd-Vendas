package br.com.slloww.sa.DTOs;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.slloww.sa.entities.Order;

public class OrderDTO implements Serializable {
		private static final long serialVersionUID = 1L;

		private Long id;
		private LocalDateTime date;
		private String user_name;
		private String admin_name;
		private Long user_id;
		private Long admin_id;

		public OrderDTO() {
		}

		public OrderDTO(Order order) {
			super();
			this.id = order.getId();
			this.date = order.getDate();
			this.user_name = order.getCustomer().getName();
			this.admin_name = order.getSeller().getName();
			this.user_id = order.getCustomer().getId();
			this.admin_id = order.getSeller().getId();
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

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}

		public String getAdmin_name() {
			return admin_name;
		}

		public void setAdmin_name(String admin_name) {
			this.admin_name = admin_name;
		}

		public Long getUser_id() {
			return user_id;
		}

		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}

		public Long getAdmin_id() {
			return admin_id;
		}

		public void setAdmin_id(Long admin_id) {
			this.admin_id = admin_id;
		}
}
