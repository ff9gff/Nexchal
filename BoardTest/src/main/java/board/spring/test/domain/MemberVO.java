package board.spring.test.domain;

import java.sql.Timestamp;

public class MemberVO {

	private String userid;
	private String userpwd;
	private String username;
	private String useremail;
	private Timestamp userregdate;
	private Timestamp userupdatedate;

	public MemberVO() {

	}

	public MemberVO(String userid, String userpwd, String username, String useremail, Timestamp userregdate,
			Timestamp userupdatedate) {
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.useremail = useremail;
		this.userregdate = userregdate;
		this.userupdatedate = userupdatedate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public Timestamp getUserregdate() {
		return userregdate;
	}

	public void setUserregdate(Timestamp userregdate) {
		this.userregdate = userregdate;
	}

	public Timestamp getUserupdatedate() {
		return userupdatedate;
	}

	public void setUserupdatedate(Timestamp userupdatedate) {
		this.userupdatedate = userupdatedate;
	}
	
	@Override
    public String toString() {
        return "MemberVO [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", useremail="
                + useremail + ", userregdate=" + userregdate + ", userupdatedate=" + userupdatedate + "]";
    }

}
