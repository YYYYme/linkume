package com.cn.linkume.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserDto implements Serializable  {

	private static final long serialVersionUID = -7650119756397477548L;

	private Long id;

	private String email;

	private String username;

	private String password;

	private String drawPwd;

	private String mobilephone;

	private String telephone;

	private Integer vipLevel;

	private Integer enable;

	private Integer ccfp;

	private String ccfpCode;

	private Date ccfpTime;

	private BigDecimal balance;

	private BigDecimal experienceBalance;

	private BigDecimal repeatBalance;

	private Date createTime;

	private Date updateTime;

	private Date vipEndTime;

	private String realName;

	private String idNo;

	private String usercode;

	private Integer phoneCheck;

	private Integer emalCheck;

	private Long updateUserId;

	private String updateUserType;

	private Integer authStep;

	private BigDecimal investFreeze;

	private BigDecimal withdrawFreeze;

	private BigDecimal recallFreeze;

	private Integer userType;

	private Long creditorFreeze;

	private String customersupId;

	private BigDecimal goldCoin;

	private Integer afpLevel;
	
	private int step;//1，未�?��,2:未绑卡，3:未开通快捷投�?4:已开通快捷投�?

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getDrawPwd() {
		return drawPwd;
	}

	public void setDrawPwd(String drawPwd) {
		this.drawPwd = drawPwd == null ? null : drawPwd.trim();
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone == null ? null : mobilephone.trim();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	public Integer getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public Integer getCcfp() {
		return ccfp;
	}

	public void setCcfp(Integer ccfp) {
		this.ccfp = ccfp;
	}

	public String getCcfpCode() {
		return ccfpCode;
	}

	public void setCcfpCode(String ccfpCode) {
		this.ccfpCode = ccfpCode == null ? null : ccfpCode.trim();
	}

	public Date getCcfpTime() {
		return ccfpTime;
	}

	public void setCcfpTime(Date ccfpTime) {
		this.ccfpTime = ccfpTime;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getExperienceBalance() {
		return experienceBalance;
	}

	public void setExperienceBalance(BigDecimal experienceBalance) {
		this.experienceBalance = experienceBalance;
	}

	public BigDecimal getRepeatBalance() {
		return repeatBalance;
	}

	public void setRepeatBalance(BigDecimal repeatBalance) {
		this.repeatBalance = repeatBalance;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getVipEndTime() {
		return vipEndTime;
	}

	public void setVipEndTime(Date vipEndTime) {
		this.vipEndTime = vipEndTime;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName == null ? null : realName.trim();
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo == null ? null : idNo.trim();
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode == null ? null : usercode.trim();
	}

	public Integer getPhoneCheck() {
		return phoneCheck;
	}

	public void setPhoneCheck(Integer phoneCheck) {
		this.phoneCheck = phoneCheck;
	}

	public Integer getEmalCheck() {
		return emalCheck;
	}

	public void setEmalCheck(Integer emalCheck) {
		this.emalCheck = emalCheck;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserType() {
		return updateUserType;
	}

	public void setUpdateUserType(String updateUserType) {
		this.updateUserType = updateUserType == null ? null : updateUserType.trim();
	}

	public Integer getAuthStep() {
		return authStep;
	}

	public void setAuthStep(Integer authStep) {
		this.authStep = authStep;
	}

	public BigDecimal getInvestFreeze() {
		return investFreeze;
	}

	public void setInvestFreeze(BigDecimal investFreeze) {
		this.investFreeze = investFreeze;
	}

	public BigDecimal getWithdrawFreeze() {
		return withdrawFreeze;
	}

	public void setWithdrawFreeze(BigDecimal withdrawFreeze) {
		this.withdrawFreeze = withdrawFreeze;
	}

	public BigDecimal getRecallFreeze() {
		return recallFreeze;
	}

	public void setRecallFreeze(BigDecimal recallFreeze) {
		this.recallFreeze = recallFreeze;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Long getCreditorFreeze() {
		return creditorFreeze;
	}

	public void setCreditorFreeze(Long creditorFreeze) {
		this.creditorFreeze = creditorFreeze;
	}

	public String getCustomersupId() {
		return customersupId;
	}

	public void setCustomersupId(String customersupId) {
		this.customersupId = customersupId == null ? null : customersupId.trim();
	}

	public BigDecimal getGoldCoin() {
		return goldCoin;
	}

	public void setGoldCoin(BigDecimal goldCoin) {
		this.goldCoin = goldCoin;
	}

	public Integer getAfpLevel() {
		return afpLevel;
	}

	public void setAfpLevel(Integer afpLevel) {
		this.afpLevel = afpLevel;
	}

	/****
	 * 1，未�?��,2:未绑卡，3:未开通快捷投�?4:已开通快捷投�?
	 * @return
	 */
	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
	
	
}
