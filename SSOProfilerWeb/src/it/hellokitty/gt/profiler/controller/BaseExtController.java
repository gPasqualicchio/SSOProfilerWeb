package it.hellokitty.gt.profiler.controller;

import it.hellokitty.gt.ssoprofiler.service.ServiceExt;
import it.hellokitty.gt.ssoprofiler.service.impl.ServiceImplExt;


public abstract class BaseExtController {

	protected ServiceExt extService = ServiceImplExt.getInstance();
}
