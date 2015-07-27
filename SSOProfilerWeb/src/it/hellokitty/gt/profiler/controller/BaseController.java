package it.hellokitty.gt.profiler.controller;

import it.hellokitty.gt.ssoprofiler.service.Service;
import it.hellokitty.gt.ssoprofiler.service.impl.ServiceImpl;

public class BaseController {
	protected Service Service = ServiceImpl.getInstance();
}
