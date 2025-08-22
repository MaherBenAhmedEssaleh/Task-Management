package com.taskmanagement.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

import com.taskmanagement.enums.MemberRole;

@Entity
@Table(name = "project_members")
public class ProjectMember {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Enumerated(EnumType.STRING)
	    private MemberRole role;
	    
	    @Column(name = "joined_at")
	    private LocalDateTime joinedAt;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "project_id", nullable = false)
	    private Project project;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;
	    
	    @PrePersist
	    protected void onCreate() {
	        joinedAt = LocalDateTime.now();
	    }

		public ProjectMember() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ProjectMember(Long id, MemberRole role, LocalDateTime joinedAt) {
			super();
			this.id = id;
			this.role = role;
			this.joinedAt = joinedAt;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public MemberRole getRole() {
			return role;
		}

		public void setRole(MemberRole role) {
			this.role = role;
		}

		public LocalDateTime getJoinedAt() {
			return joinedAt;
		}

		public void setJoinedAt(LocalDateTime joinedAt) {
			this.joinedAt = joinedAt;
		}

		public Project getProject() {
			return project;
		}

		public void setProject(Project project) {
			this.project = project;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
	    
	    

}
