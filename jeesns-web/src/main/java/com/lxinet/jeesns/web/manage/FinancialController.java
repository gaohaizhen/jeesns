package com.lxinet.jeesns.web.manage;

import com.lxinet.jeesns.core.annotation.Before;
import com.lxinet.jeesns.core.annotation.UsePage;
import com.lxinet.jeesns.core.dto.ResultModel;
import com.lxinet.jeesns.core.model.Page;
import com.lxinet.jeesns.core.utils.PageUtil;
import com.lxinet.jeesns.interceptor.AdminLoginInterceptor;
import com.lxinet.jeesns.model.common.Link;
import com.lxinet.jeesns.model.member.Financial;
import com.lxinet.jeesns.service.common.ILinkService;
import com.lxinet.jeesns.service.member.IFinancialService;
import com.lxinet.jeesns.web.common.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zchuanzhao on 2018/11/28.
 */
@Controller
@RequestMapping("/${managePath}/member/financial/")
@Before(AdminLoginInterceptor.class)
public class FinancialController extends BaseController{
    private static final String MANAGE_FTL_PATH = "/manage/member/financial/";
    @Resource
    private IFinancialService financialService;

    @UsePage
    @RequestMapping("list")
    public String list(Model model, @RequestParam(value = "memberId",required = false, defaultValue = "0") Integer memberId){
        List<Financial> list = financialService.list(memberId);
        ResultModel resultModel = new ResultModel(0, PageUtil.getPage());
        resultModel.setData(list);
        model.addAttribute("model", resultModel);
        return MANAGE_FTL_PATH + "list";
    }

}
