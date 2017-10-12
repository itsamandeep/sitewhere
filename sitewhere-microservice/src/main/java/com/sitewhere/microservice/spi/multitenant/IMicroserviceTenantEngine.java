package com.sitewhere.microservice.spi.multitenant;

import org.springframework.context.ApplicationContext;

import com.sitewhere.microservice.spi.configuration.IConfigurationListener;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.server.lifecycle.ILifecycleProgressMonitor;
import com.sitewhere.spi.server.lifecycle.ITenantLifecycleComponent;

/**
 * Engine that manages operations for a single tenant within an
 * {@link IMultitenantMicroservice}.
 * 
 * @author Derek
 */
public interface IMicroserviceTenantEngine extends ITenantLifecycleComponent, IConfigurationListener {

    /**
     * Get parent microservice.
     * 
     * @return
     */
    public IMultitenantMicroservice getMicroservice();

    /**
     * Get Zk configuration path for tenant.
     * 
     * @return
     * @throws SiteWhereException
     */
    public String getTenantConfigurationPath() throws SiteWhereException;

    /**
     * Get Spring context that provides beans for module.
     * 
     * @return
     */
    public ApplicationContext getModuleContext();

    /**
     * Get Zk configuration path for module configuration.
     * 
     * @return
     * @throws SiteWhereException
     */
    public String getModuleConfigurationPath() throws SiteWhereException;

    /**
     * Executes tenant initialization code. Called after Spring context has been
     * loaded.
     * 
     * @param monitor
     * @throws SiteWhereException
     */
    public void tenantInitialize(ILifecycleProgressMonitor monitor) throws SiteWhereException;

    /**
     * Executes tenant startup code.
     * 
     * @param monitor
     * @throws SiteWhereException
     */
    public void tenantStart(ILifecycleProgressMonitor monitor) throws SiteWhereException;

    /**
     * Executes tenant shutdown code.
     * 
     * @param monitor
     * @throws SiteWhereException
     */
    public void tenantStop(ILifecycleProgressMonitor monitor) throws SiteWhereException;
}