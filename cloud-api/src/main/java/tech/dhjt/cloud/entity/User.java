package tech.dhjt.cloud.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 用户表
 * @author DHJT
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class User implements Serializable {

	private static final long serialVersionUID = 2030167649218340345L;

	private Integer id;

	private String username;

	private String nikename;

	private boolean deleted;

}
