package tech.dhjt.cloud.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @description 部门类
 * @author DHJT 2019年4月17日 下午3:06:34
 */
@TableName("dept")
public class Dept implements Serializable {

	private static final long serialVersionUID = -4680205525157259757L;
	/**
	 * @description 主键
	 */
	@TableId
	private Long deptNo;
	/**
	 * @description 部门名称
	 */
	private String deptName;
	/**
	 * @description 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
	 */
	private String dbSource;

    public Long getDeptNo() {
        return deptNo;
    }
    public void setDeptNo(Long deptNo) {
        this.deptNo = deptNo;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getDbSource() {
        return dbSource;
    }
    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    public Dept() {
        super();
    }

    public Dept(String deptName) {
        super();
        this.deptName = deptName;
    }

    public Dept(Long deptNo, String deptName, String dbSource) {
        super();
        this.deptName = deptName;
        this.dbSource = dbSource;
        this.deptNo = deptNo;
    }

}
