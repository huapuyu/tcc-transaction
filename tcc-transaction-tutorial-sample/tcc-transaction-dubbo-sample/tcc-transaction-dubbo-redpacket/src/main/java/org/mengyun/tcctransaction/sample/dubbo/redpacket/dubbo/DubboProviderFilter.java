package org.mengyun.tcctransaction.sample.dubbo.redpacket.dubbo;

import java.util.HashSet;
import java.util.Set;

import org.mengyun.tcctransaction.api.base.BaseResponse;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcResult;

//@Activate(group = {Constants.PROVIDER, Constants.CONSUMER})
@Activate(group = { com.alibaba.dubbo.common.Constants.PROVIDER })
public class DubboProviderFilter implements Filter {

	private final static Set<String> EXCLUDES = new HashSet<String>();

	static {
		EXCLUDES.add(com.alibaba.dubbo.monitor.MonitorService.class.getName());
	}

	@Override
	public Result invoke(Invoker<?> invoker, final Invocation invocation)
			throws RpcException {
		Result result = null;
		try {
			result = invoker.invoke(invocation);

			if (result != null && result instanceof RpcResult) {
				RpcResult rpcResult = (RpcResult) result;
				Throwable throwable = rpcResult.getException();
				Object resultObject = rpcResult.getValue();
				if (resultObject instanceof BaseResponse) {
					BaseResponse baseResponse = (BaseResponse) resultObject;
					if (throwable != null) {
						baseResponse.setErrorCode("1111");
						rpcResult.setException(null);
					}
				} else if (resultObject instanceof String
						|| resultObject instanceof Integer
						|| resultObject instanceof Long
						|| resultObject instanceof Double
						|| resultObject instanceof Float
						|| resultObject instanceof Character
						|| resultObject instanceof Boolean) {
				}
				return result;
			}

			if (result == null) {
				throw new RpcException("dubbo result is null");
			}
			return result;
		} catch (Throwable e) {
			throw new RpcException(e);
		} finally {
		}
	}
}
