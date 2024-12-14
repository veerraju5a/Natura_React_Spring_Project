package com.natura.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.natura.entities.Role;

import jakarta.persistence.*;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
//@NoArgsConstructor
//@Data
//@ToString
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Userid;
    private String Name;
    private String email;
    @Column(nullable = false)
    private String Password;
    private String Contact;
    public int getUserid() {
		return Userid;
	}

	public void setUserid(int userid) {
		Userid = userid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setPassword(String password) {
		Password = password;
	}



    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private List<Role> role;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> role;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Cart cart;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = role.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRole()))
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public String toString() {
		return "User [Userid=" + Userid + ", Name=" + Name + ", email=" + email + ", Password=" + Password
				+ ", Contact=" + Contact + ", date=" + date + ", role=" + role + ", cart=" + cart + "]";
	}
    
    
}
