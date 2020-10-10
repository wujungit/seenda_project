package com.seenda.basic.common.dto.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("MemberDTO")
public class MemberDTO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("serial")
    private String serial;

}
