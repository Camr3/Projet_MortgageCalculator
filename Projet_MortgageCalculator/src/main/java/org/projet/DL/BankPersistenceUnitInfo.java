package org.projet.DL;

import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

import javax.sql.DataSource;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class BankPersistenceUnitInfo implements PersistenceUnitInfo {
    @Override
    public String getPersistenceUnitName() {
        return "BankPersistenceUnitInfo";
    }

    @Override
    public String getPersistenceProviderClassName() {

        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {

        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public DataSource getJtaDataSource() {

        return null;
    }

    @Override
    public DataSource getNonJtaDataSource() {

        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return Collections.emptyList();
    }

    @Override
    public List<URL> getJarFileUrls() {
        return Collections.emptyList();
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        List<String> managedClassNames = new ArrayList<>();
        managedClassNames.add("org.projet.BLL.Model.Bank");
        managedClassNames.add("org.projet.BLL.Model.Service");
      return managedClassNames;
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return SharedCacheMode.UNSPECIFIED;
    }

    @Override
    public ValidationMode getValidationMode() {
        return ValidationMode.AUTO;
    }

    @Override
    public Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.format_sql", "false");
        properties.setProperty("hibernate.use_sql_comments", "false");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.ejb.interceptor", "org.hibernate.ejb.interceptor.EmptyInterceptor");

        properties.setProperty("javax.persistence.jdbc.password", "6284588");
        properties.setProperty("javax.persistence.jdbc.url", "jdbc:mariadb://mysql-camilomantilla.alwaysdata.net/camilomantilla_bdeb");
        properties.setProperty("javax.persistence.jdbc.user", "389935_bdeb");
        properties.setProperty("javax.persistence.jdbc.driver", "org.mariadb.jdbc.Driver");
        properties.setProperty("javax.persistence.schema-generation.database.action", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        return properties;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return "3.0";
    }

    @Override
    public ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    @Override
    public void addTransformer(ClassTransformer transformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {

        return null;
    }
}