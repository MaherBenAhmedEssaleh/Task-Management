package com.taskmanagement.model;

import com.taskmanagement.enums.NotificationType;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(nullable = false, length = 200)
	    private String title;
	    
	    @Column(nullable = false, length = 500)
	    private String message;
	    
	    @Enumerated(EnumType.STRING)
	    private NotificationType type;
	    
	    
	    private Boolean read = false;
	    
	    @Column(name = "entity_id")
	    private Long entityId;
	    
	    @Column(name = "entity_type")
	    private String entityType;
	    
	    @Column(name = "created_at")
	    private LocalDateTime createdAt;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "recipient_id", nullable = false)
	    private User recipient;
	    
	    @PrePersist
	    protected void onCreate() {
	        createdAt = LocalDateTime.now();
	    }

		public Notification() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Notification(Long id, String title, String message, NotificationType type, Boolean read, Long entityId,
				String entityType, LocalDateTime createdAt, User recipient) {
			super();
			this.id = id;
			this.title = title;
			this.message = message;
			this.type = type;
			this.read = read;
			this.entityId = entityId;
			this.entityType = entityType;
			this.createdAt = createdAt;
			this.recipient = recipient;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public NotificationType getType() {
			return type;
		}

		public void setType(NotificationType type) {
			this.type = type;
		}

		public Boolean getRead() {
			return read;
		}

		public void setRead(Boolean read) {
			this.read = read;
		}

		public Long getEntityId() {
			return entityId;
		}

		public void setEntityId(Long entityId) {
			this.entityId = entityId;
		}

		public String getEntityType() {
			return entityType;
		}

		public void setEntityType(String entityType) {
			this.entityType = entityType;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public User getRecipient() {
			return recipient;
		}

		public void setRecipient(User recipient) {
			this.recipient = recipient;
		}
	    
	    

}
