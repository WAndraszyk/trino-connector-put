/* *************************************************** */

/* (C) Copyright IBM Corp. 2022                        */

/* *************************************************** */
package com.yourorganizationname.connect.trino;

import java.util.Collections;

import com.ibm.wdp.connect.common.sdk.api.models.CustomDatasourceTypeAction;
import com.ibm.wdp.connect.common.sdk.api.models.CustomDatasourceTypeActionProperties;
import com.ibm.wdp.connect.common.sdk.api.models.CustomDatasourceTypeProperty;
import com.ibm.wdp.connect.common.sdk.api.models.CustomDatasourceTypeProperty.TypeEnum;
import com.ibm.wdp.connect.common.sdk.api.models.CustomFlightDatasourceType;
import com.ibm.wdp.connect.common.sdk.api.models.CustomFlightDatasourceTypeProperties;
import com.ibm.wdp.connect.common.sdk.api.models.DatasourceTypePropertyValues;

@SuppressWarnings({ "PMD.AvoidDollarSigns", "PMD.ClassNamingConventions" })
public class TrinoDatasourceType extends CustomFlightDatasourceType
{
    /**
     * An instance of the custom Apache Derby data source type.
     */
    public static final TrinoDatasourceType INSTANCE = new TrinoDatasourceType();

    /**
     * The unique identifier name of the data source type.
     */
    public static final String DATASOURCE_TYPE_NAME = "trino";
    private static final String DATASOURCE_TYPE_LABEL = "trino";
    private static final String DATASOURCE_TYPE_DESCRIPTION = "trino (SDK)";

    public TrinoDatasourceType()
    {
        super();

        // Set the data source type attributes.
        setName(DATASOURCE_TYPE_NAME);
        setLabel(DATASOURCE_TYPE_LABEL);
        setDescription(DATASOURCE_TYPE_DESCRIPTION);
        setAllowedAsSource(true);
        setAllowedAsTarget(true);
        setStatus(CustomFlightDatasourceType.StatusEnum.PENDING);
        setTags(Collections.emptyList());
        final CustomFlightDatasourceTypeProperties properties = new CustomFlightDatasourceTypeProperties();
        setProperties(properties);
        // Define the connection properties.
        // TODO adjust these properties for your scenario
        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("host")
                .label("Host")
                .description("Name of server")
                .type(TypeEnum.STRING)
                .required(true)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("port")
                .label("Port")
                .description("Port number")
                .type(TypeEnum.INTEGER)
                .required(true)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("user")
                .label("User")
                .description("Username to use for authentication and authorization.")
                .type(TypeEnum.STRING)
                .required(true)
                .group("credentials"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("password")
                .label("Password")
                .description("Password to use for LDAP authentication.")
                .type(TypeEnum.STRING)
                .required(true)
                .group("credentials"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("sessionUser")
                .label("Session User")
                .description("Session username override, used for impersonation.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("credentials"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("socksProxy")
                .label("SOCKS Proxy")
                .description("SOCKS proxy host and port. Example: localhost:1080")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("httpProxy")
                .label("HTTP Proxy")
                .description("HTTP proxy host and port. Example: localhost:8888")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("clientInfo")
                .label("Client Info")
                .description("Extra information about the client.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("clientTags")
                .label("Client Tags")
                .description("Client tags for selecting resource groups. Example: abc,xyz")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("traceToken")
                .label("Trace Token")
                .description("Trace token for correlating requests across systems.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("source")
                .label("Source")
                .description("Source name for the Trino query. This parameter should be used in preference to ApplicationName. Thus, it takes precedence over ApplicationName and/or applicationNamePrefix.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("applicationNamePrefix")
                .label("Application Name Prefix")
                .description("Prefix to append to any specified ApplicationName client info property, which is used to set the source name for the Trino query if the source parameter has not been set. If neither this property nor ApplicationName or source are set, the source name for the query is trino-jdbc.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("accessToken")
                .label("Access Token")
                .description("JWT access token for token based authentication.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("SSL")
                .label("SSL")
                .description("Set true to specify using TLS/HTTPS for connections.")
                .type(TypeEnum.STRING)
                .required(true)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("SSLVerification")
                .label("SSL Verification")
                .description("The method of TLS verification. There are three modes: FULL (default), CA and NONE. For FULL, the normal TLS verification is performed. For CA, only the CA is verified but hostname mismatch is allowed. For NONE, there is no verification.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("SSLKeyStorePath")
                .label("SSL KeyStore Path")
                .description("Use only when connecting to a Trino cluster that has certificate authentication enabled. Specifies the path to a PEM or JKS file, which must contain a certificate that is trusted by the Trino cluster you connect to.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("SSLKeyStorePassword")
                .label("SSL KeyStore Password")
                .description("The password for the KeyStore, if any.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("SSLKeyStoreType")
                .label("SSL KeyStore Type")
                .description("The type of the KeyStore. The default type is provided by the Java keystore.type security property or jks if none exists.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("SSLTrustStorePath")
                .label("SSL TrustStore Path")
                .description("The location of the Java TrustStore file to use to validate HTTPS server certificates.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("SSLTrustStorePassword")
                .label("SSL TrustStore Password")
                .description("The password for the TrustStore.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("SSLTrustStoreType")
                .label("SSL TrustStore Type")
                .description("The type of the TrustStore. The default type is provided by the Java keystore.type security property or jks if none exists.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("SSLUseSystemTrustStore")
                .label("SSL Use System TrustStore")
                .description("Set true to automatically use the system TrustStore based on the operating system. The supported OSes are Windows and macOS. For Windows, the Windows-ROOT TrustStore is selected. For macOS, the KeychainStore TrustStore is selected. For other OSes, the default Java TrustStore is loaded. The TrustStore specification can be overridden using SSLTrustStoreType.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("KerberosRemoteServiceName")
                .label("Kerberos Remote Service Name")
                .description("Trino coordinator Kerberos service name. This parameter is required for Kerberos authentication.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("KerberosPrincipal")
                .label("Kerberos Principal")
                .description("The principal to use when authenticating to the Trino coordinator.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("KerberosUseCanonicalHostname")
                .label("Kerberos Use Canonical Hostname")
                .description("Use the canonical hostname of the Trino coordinator for the Kerberos service principal by first resolving the hostname to an IP address and then doing a reverse DNS lookup for that IP address. This is enabled by default.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("KerberosServicePrincipalPattern")
                .label("Kerberos Service Principal Pattern")
                .description("Trino coordinator Kerberos service principal pattern. The default is ${SERVICE}@${HOST}. ${SERVICE} is replaced with the value of KerberosRemoteServiceName and ${HOST} is replaced with the hostname of the coordinator (after canonicalization if enabled).")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("KerberosConfigPath")
                .label("Kerberos Config Path")
                .description("Kerberos configuration file.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("KerberosKeytabPath")
                .label("Kerberos Keytab Path")
                .description("Kerberos keytab file.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("KerberosCredentialCachePath")
                .label("Kerberos Credential Cache Path")
                .description("Kerberos credential cache.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("KerberosDelegation")
                .label("Kerberos Delegation")
                .description("Set to true to use the token from an existing Kerberos context. This allows clients to use Kerberos authentication without passing the Keytab or credential cache. Defaults to false.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("extraCredentials")
                .label("Extra Credentials")
                .description("Extra credentials for connecting to external services, specified as a list of key-value pairs. For example, foo:bar;abc:xyz creates the credential named abc with value xyz and the credential named foo with value bar.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("roles")
                .label("Roles")
                .description("Authorization roles to use for catalogs, specified as a list of key-value pairs for the catalog and role. For example, catalog1:roleA;catalog2:roleB sets roleA for catalog1 and roleB for catalog2.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("sessionProperties")
                .label("Session Properties")
                .description("Session properties to set for the system and for catalogs, specified as a list of key-value pairs. For example, abc:xyz;example.foo:bar sets the system property abc to the value xyz and the foo property for catalog example to the value bar.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("externalAuthentication")
                .label("External Authentication")
                .description("Set to true if you want to use external authentication via OAuth 2.0 authentication. Use a local web browser to authenticate with an identity provider (IdP) that has been configured for the Trino coordinator.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("externalAuthenticationTokenCache")
                .label("External Authentication Token Cache")
                .description("Allows the sharing of external authentication tokens between different connections for the same authenticated user until the cache is invalidated, such as when a client is restarted or when the classloader reloads the JDBC driver. This is disabled by default, with a value of NONE. To enable, set the value to MEMORY. If the JDBC driver is used in a shared mode by different users, the first registered token is stored and authenticates all users.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("disableCompression")
                .label("Disable Compression")
                .description("Whether compression should be enabled.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        properties.addConnectionItem(new CustomDatasourceTypeProperty()
                .name("assumeLiteralUnderscoreInMetadataCallsForNonConformingClients")
                .label("Assume Literal Underscore")
                .description("When enabled, the name patterns passed to DatabaseMetaData methods are treated as underscores. You can use this as a workaround for applications that do not escape schema or table names when passing them to DatabaseMetaData methods as schema or table name patterns.")
                .type(TypeEnum.STRING)
                .required(false)
                .group("domain"));

        // Define the source interaction properties.
        properties.addSourceItem(new CustomDatasourceTypeProperty().name("schema_name").label("Schema name")
                .description("The name of the schema that contains the table to read from").type(TypeEnum.STRING).required(false));
        properties.addSourceItem(new CustomDatasourceTypeProperty().name("table_name").label("Table name")
                .description("The name of the table to read from").type(TypeEnum.STRING).required(false));
        properties.addSourceItem(new CustomDatasourceTypeProperty().name("row_limit").label("Row limit")
                .description("The maximum number of rows to return").type(TypeEnum.INTEGER).required(false));
        properties.addSourceItem(new CustomDatasourceTypeProperty().name("byte_limit").label("Byte limit")
                .description("The maximum number of bytes to return. Use any of these suffixes; KB, MB, GB, or TB").type(TypeEnum.STRING)
                .required(false));

        // Define the target interaction properties.
        properties.addTargetItem(new CustomDatasourceTypeProperty().name("schema_name").label("Schema name")
                .description("The name of the schema that contains the table to write to").type(TypeEnum.STRING).required(false));
        properties.addTargetItem(new CustomDatasourceTypeProperty().name("table_name").label("Table name")
                .description("The name of the table to write to").type(TypeEnum.STRING).required(true));
        properties.addTargetItem(new CustomDatasourceTypeProperty().name("table_action").label("Table action")
                .description("The action to take on the target table to handle the new data set").type(TypeEnum.ENUM).required(false)
                .defaultValue("append").addValuesItem(new DatasourceTypePropertyValues().value("append").label("Append"))
                .addValuesItem(new DatasourceTypePropertyValues().value("replace").label("Replace"))
                .addValuesItem(new DatasourceTypePropertyValues().value("truncate").label("Truncate")));
        properties.addTargetItem(new CustomDatasourceTypeProperty().name("create_statement").label("Create statement")
                .description("The Create DDL statement for creating the target table").type(TypeEnum.STRING).required(false));

        // Define the filter properties.
        properties.addFilterItem(new CustomDatasourceTypeProperty().name("include_system").label("Include system")
                .description("Whether to include system objects").type(TypeEnum.BOOLEAN).required(false));
        properties.addFilterItem(new CustomDatasourceTypeProperty().name("include_table").label("Include tables")
                .description("Whether to include tables").type(TypeEnum.BOOLEAN).required(false));
        properties.addFilterItem(new CustomDatasourceTypeProperty().name("include_view").label("Include views")
                .description("Whether to include views").type(TypeEnum.BOOLEAN).required(false));
        properties.addFilterItem(new CustomDatasourceTypeProperty().name("name_pattern").label("Name pattern")
                .description("A name pattern to filter on").type(TypeEnum.STRING).required(false));
        properties.addFilterItem(new CustomDatasourceTypeProperty().name("primary_key").label("Include primary key list")
                .description("Whether to include a list of primary keys").type(TypeEnum.BOOLEAN).required(false));
        properties.addFilterItem(new CustomDatasourceTypeProperty().name("schema_name_pattern").label("Schema name pattern")
                .description("A name pattern for schema filtering").type(TypeEnum.STRING).required(false));

        // Define custom actions.
        final CustomDatasourceTypeActionProperties actionProperties = new CustomDatasourceTypeActionProperties();
        final CustomDatasourceTypeAction action = new CustomDatasourceTypeAction().name("get_record_count")
                .description("Get the number of rows in the specified table").properties(actionProperties);
        actionProperties.addInputItem(new CustomDatasourceTypeProperty().name("schema_name").label("Schema name")
                .description("The name of the schema that contains the table").type(TypeEnum.STRING).required(false));
        actionProperties.addInputItem(new CustomDatasourceTypeProperty().name("table_name").label("Table name")
                .description("Name of the table for which to obtain the number of rows").type(TypeEnum.STRING).required(true));
        actionProperties.addOutputItem(new CustomDatasourceTypeProperty().name("record_count").label("Record count")
                .description("Number of available rows").type(TypeEnum.INTEGER).required(true));
        addActionsItem(action);
    }
}
