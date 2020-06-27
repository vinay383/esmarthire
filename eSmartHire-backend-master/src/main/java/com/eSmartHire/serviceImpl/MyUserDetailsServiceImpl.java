package com.eSmartHire.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.eSmartHire.model.MasterUser;
import com.eSmartHire.model.MyUserDetails;
import com.eSmartHire.repository.MasterUserRepository;
import com.eSmartHire.service.MyUserDetailsService;

@Component
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

	@Autowired
	MasterUserRepository masterUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MasterUser> user = masterUserRepository.findByUserEmailId(username);
		return user.map(MyUserDetails::new).get();
	}
}
