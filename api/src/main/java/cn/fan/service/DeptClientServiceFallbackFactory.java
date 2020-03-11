package cn.fan.service;

import cn.fan.entity.Dept;
import com.github.pagehelper.PageInfo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 不要忘记添加，不要忘记添加  大坑！！！！！！
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>
{
	@Override
	public DeptClientService create(Throwable throwable)
	{
		return new DeptClientService() {
			@Override
			public Dept get(long id)
			{
				Dept dept=new Dept();
				dept.setDeptno(id);
				dept.setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand");
				dept.setDb_source("no this database in MySQL");
				return dept;
			}

//			@Override

			@Override
			public PageInfo<Dept> list(int page, int size) {
				return null;
			}
//			public List<Dept> list()
//			{
//				return null;
//			}

			@Override
			public boolean add(Dept dept)
			{
				return false;
			}
		};
	}
}
