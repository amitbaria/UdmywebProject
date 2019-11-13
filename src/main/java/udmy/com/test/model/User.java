package udmy.com.test.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="UserTable")
public class User {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE)
	 @Column(name="USERID")
	 private Integer userid;
	 
	 
	 @Column(name="USERNAME", nullable=false)
	 private String userName;
	 @Column(name="USEREMAIL",nullable=false)
	 private String userEmail;
	 @Column(name="USERADDRESS",nullable=false)
	 private String userAddress;
	 
	 
	 //  It will ignore creation of column in Table.......
	 @Transient
	 @Column(name="IgnoreColumn")
	 private  String ignoreColumnCreation;
	 @Column(name="modifiedBy")
	 private  Date modifiedBy;
	 
	 
	 
	 //   hibernate mapping 'java  Date Object with 'date'  data type  in database. 
	 @Temporal(TemporalType.DATE)
	 @Column(name="userDOB")
	 private  Date userDOB;
	 
	
	 // ByDefault  hibernate mapping  'java  Date Object with 'datetime'   time stamp in database.
	 @Column(name="createdBy")
	 private  Date ceatedBy;
	 
	 
	 
	@OneToMany(cascade=CascadeType.ALL  ,mappedBy="user",fetch = FetchType.EAGER)
    private  Set<LoanAccounts>  loansAccount;
	

	
	
	 public Set<LoanAccounts> getLoansAccount() {
		return loansAccount;
	}



	public void setLoansAccount(Set<LoanAccounts> loansAccount) {
		this.loansAccount = loansAccount;
	}



	public Integer getUserid() {
		return userid;
	}



	public void setUserid(Integer userid) {
		this.userid = userid;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getUserAddress() {
		return userAddress;
	}



	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}



	public String getIgnoreColumnCreation() {
		return ignoreColumnCreation;
	}



	public void setIgnoreColumnCreation(String ignoreColumnCreation) {
		this.ignoreColumnCreation = ignoreColumnCreation;
	}



	public Date getModifiedBy() {
		return modifiedBy;
	}



	public void setModifiedBy(Date modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	public Date getUserDOB() {
		return userDOB;
	}



	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}



	public Date getCeatedBy() {
		return ceatedBy;
	}



	public void setCeatedBy(Date ceatedBy) {
		this.ceatedBy = ceatedBy;
	}



	


	 
	 
	 
	 
	
	 

}
