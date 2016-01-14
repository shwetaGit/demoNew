package testprj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import testprj.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import testprj.app.server.repository.SalesDataRepository;
import testprj.app.shared.sales.SalesData;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import testprj.app.shared.sales.Brand;
import testprj.app.server.repository.BrandRepository;
import testprj.app.shared.sales.Category;
import testprj.app.server.repository.CategoryRepository;
import testprj.app.shared.sales.Channel;
import testprj.app.server.repository.ChannelRepository;
import testprj.app.shared.sales.Material;
import testprj.app.server.repository.MaterialRepository;
import testprj.app.shared.sales.Retailer;
import testprj.app.server.repository.RetailerRepository;
import testprj.app.shared.sales.Distributor;
import testprj.app.server.repository.DistributorRepository;
import testprj.app.shared.sales.SalesRegion;
import testprj.app.server.repository.SalesRegionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class SalesDataTestCase {

    @Autowired
    private SalesDataRepository<SalesData> salesdataRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            Brand brand = new Brand();
            brand.setBranddesc("YELzA2FWHROiGMzUNZh5Yu1MXqNr7D8H8HuHMrm1RMZeK7MUce");
            Category category = new Category();
            category.setCategory("f6SMTjwiaTeBxYlX4WESSOWvtRFYnxea1mfldg4d5swl5qyFGz");
            Category CategoryTest = categoryRepository.save(category);
            map.put("CategoryPrimaryKey", category._getPrimarykey());
            brand.setBranddesc("6LFpdQnz1SCgbnkdoOQCeabxTBD9Zy02nYk9REkQEP5F7Hp3VK");
            brand.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            Brand BrandTest = brandRepository.save(brand);
            map.put("BrandPrimaryKey", brand._getPrimarykey());
            Channel channel = new Channel();
            channel.setChannel("iNXJy0gHpPL1pVFASHy8fWX5M6j0CteQzYUUzzZJAfxO5LKCep");
            Channel ChannelTest = channelRepository.save(channel);
            map.put("ChannelPrimaryKey", channel._getPrimarykey());
            Material material = new Material();
            material.setBrandcode((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
            material.setMaterialdesc("oEMC74pnoUNgBqUCJpvYJwpRpbtLxRVVuHleiXD0sHiK9Onky9");
            Material MaterialTest = materialRepository.save(material);
            map.put("MaterialPrimaryKey", material._getPrimarykey());
            Retailer retailer = new Retailer();
            Distributor distributor = new Distributor();
            distributor.setDistributorname("8EZCeLrLRsqG5PKR5tcp8JhgnLMhwPSMkCXGXmAG0CQ0c5rThA");
            distributor.setLattitude(12.34);
            distributor.setLongitude(12.34);
            SalesRegion salesregion = new SalesRegion();
            salesregion.setRegionname("ED9W9dDx4A55oj5ULAJYcFA4zYNEb32CTS2OIACbHsCz5KXC3n");
            SalesRegion SalesRegionTest = salesregionRepository.save(salesregion);
            map.put("SalesRegionPrimaryKey", salesregion._getPrimarykey());
            distributor.setDistributorname("oDt3ycVDccp4oIdRC3ADYlfRx6d6ziVKjOVNWFHuIIzidoCqWv");
            distributor.setLattitude(12.34);
            distributor.setLongitude(12.34);
            distributor.setRegioncode((java.lang.String) SalesRegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            Distributor DistributorTest = distributorRepository.save(distributor);
            map.put("DistributorPrimaryKey", distributor._getPrimarykey());
            retailer.setDistributorcode((java.lang.String) DistributorTest._getPrimarykey()); /* ******Adding refrenced table data */
            retailer.setRetailername("KsKqMhLJfLZ1oMEpxrFSMAiCS8lVGkYmwbRPeErSGyofuEU12r");
            Retailer RetailerTest = retailerRepository.save(retailer);
            map.put("RetailerPrimaryKey", retailer._getPrimarykey());
            SalesData salesdata = new SalesData();
            salesdata.setBrandcode((java.lang.String) BrandTest._getPrimarykey()); /* ******Adding refrenced table data */
            salesdata.setBranddesc("SonvTZzEidm1xtZbSv3zzjT6VnkogSOsyYkHLrBNbgMiQEiIWa");
            salesdata.setCategory((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            salesdata.setChannelId((java.lang.String) ChannelTest._getPrimarykey()); /* ******Adding refrenced table data */
            salesdata.setGrosssalesamt(12.34);
            salesdata.setMaterialcode((java.lang.String) MaterialTest._getPrimarykey()); /* ******Adding refrenced table data */
            salesdata.setMaterialdesc("iUVUIFwnuKlPAsAfXMDPHlL3OaQU1wKs3tObVbuvclemT8rqKU");
            salesdata.setNetsalesamt(12.34);
            salesdata.setReatilercode((java.lang.String) RetailerTest._getPrimarykey());
            salesdata.setRetailername("xHldvHfqB6RqQVnWutxWdNt3CKdNzvd8vIRlyQxKFaLBgU50D4");
            salesdata.setSalesdate(new java.sql.Date(123456789));
            salesdata.setSalesinvoicenbr("gsltVpUzQbmkKrUZKMBpsuISrPE2HiKJ9ubT7uzKvcsUH790wl");
            salesdata.setSalesmonth(2147483647);
            salesdata.setSalesqty(12.34);
            salesdata.setSalesyear(2147483647);
            salesdata.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            salesdata.setEntityValidator(entityValidator);
            salesdata.isValid();
            salesdataRepository.save(salesdata);
            map.put("SalesDataPrimaryKey", salesdata._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private BrandRepository<Brand> brandRepository;

    @Autowired
    private CategoryRepository<Category> categoryRepository;

    @Autowired
    private ChannelRepository<Channel> channelRepository;

    @Autowired
    private MaterialRepository<Material> materialRepository;

    @Autowired
    private RetailerRepository<Retailer> retailerRepository;

    @Autowired
    private DistributorRepository<Distributor> distributorRepository;

    @Autowired
    private SalesRegionRepository<SalesRegion> salesregionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("SalesDataPrimaryKey"));
            SalesData salesdata = salesdataRepository.findById((java.lang.Integer) map.get("SalesDataPrimaryKey"));
            salesdata.setBranddesc("Kz2aeSzSgS8Gqbw8Zi2na2Km5mRHPfen9pMOKJ82ycEFVf0gur");
            salesdata.setGrosssalesamt(12.34);
            salesdata.setMaterialdesc("rlsRaBNT7XnMwZC6U9e3SyumyOmgGEXIk2SLxeMkf2MvA7Krdw");
            salesdata.setNetsalesamt(12.34);
            salesdata.setRetailername("T5bUs3lzYicdCAXJZXJuoGPLLf3d0TKy1pqCWPrPcyIjYw2ddV");
            salesdata.setSalesdate(new java.sql.Date(123456789));
            salesdata.setSalesinvoicenbr("v6qTOi9s6lsr7TsmhHRZO7mkyCS9ATMU6IzItAs0TOdtkQbRSD");
            salesdata.setSalesmonth(2147483647);
            salesdata.setSalesqty(12.34);
            salesdata.setSalesyear(2147483647);
            salesdata.setVersionId(1);
            salesdata.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            salesdataRepository.update(salesdata);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("SalesDataPrimaryKey"));
            salesdataRepository.findById((java.lang.Integer) map.get("SalesDataPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBybrandcode() {
        try {
            java.util.List<SalesData> listofbrandcode = salesdataRepository.findByBrandcode((java.lang.String) map.get("BrandPrimaryKey"));
            if (listofbrandcode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycategory() {
        try {
            java.util.List<SalesData> listofcategory = salesdataRepository.findByCategory((java.lang.String) map.get("CategoryPrimaryKey"));
            if (listofcategory.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBychannelId() {
        try {
            java.util.List<SalesData> listofchannelId = salesdataRepository.findByChannelId((java.lang.String) map.get("ChannelPrimaryKey"));
            if (listofchannelId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBymaterialcode() {
        try {
            java.util.List<SalesData> listofmaterialcode = salesdataRepository.findByMaterialcode((java.lang.String) map.get("MaterialPrimaryKey"));
            if (listofmaterialcode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByreatilercode() {
        try {
            java.util.List<SalesData> listofreatilercode = salesdataRepository.findByReatilercode((java.lang.String) map.get("RetailerPrimaryKey"));
            if (listofreatilercode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("SalesDataPrimaryKey"));
            salesdataRepository.delete((java.lang.Integer) map.get("SalesDataPrimaryKey")); /* Deleting refrenced data */
            retailerRepository.delete((java.lang.String) map.get("RetailerPrimaryKey")); /* Deleting refrenced data */
            distributorRepository.delete((java.lang.String) map.get("DistributorPrimaryKey")); /* Deleting refrenced data */
            salesregionRepository.delete((java.lang.String) map.get("SalesRegionPrimaryKey")); /* Deleting refrenced data */
            materialRepository.delete((java.lang.String) map.get("MaterialPrimaryKey")); /* Deleting refrenced data */
            channelRepository.delete((java.lang.String) map.get("ChannelPrimaryKey")); /* Deleting refrenced data */
            brandRepository.delete((java.lang.String) map.get("BrandPrimaryKey")); /* Deleting refrenced data */
            categoryRepository.delete((java.lang.String) map.get("CategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
