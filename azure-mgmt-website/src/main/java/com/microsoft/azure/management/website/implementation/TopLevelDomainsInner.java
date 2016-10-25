/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.website.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceCall;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.management.website.TopLevelDomainAgreementOption;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in TopLevelDomains.
 */
public final class TopLevelDomainsInner {
    /** The Retrofit service to perform REST calls. */
    private TopLevelDomainsService service;
    /** The service client containing this operation class. */
    private WebSiteManagementClientImpl client;

    /**
     * Initializes an instance of TopLevelDomainsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public TopLevelDomainsInner(Retrofit retrofit, WebSiteManagementClientImpl client) {
        this.service = retrofit.create(TopLevelDomainsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for TopLevelDomains to be
     * used by Retrofit to perform actually REST calls.
     */
    interface TopLevelDomainsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.DomainRegistration/topLevelDomains")
        Observable<Response<ResponseBody>> list(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.DomainRegistration/topLevelDomains/{name}")
        Observable<Response<ResponseBody>> get(@Path("name") String name, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.DomainRegistration/topLevelDomains/{name}/listAgreements")
        Observable<Response<ResponseBody>> listAgreements(@Path("name") String name, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Body TopLevelDomainAgreementOption agreementOption, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("{nextLink}")
        Observable<Response<ResponseBody>> listNext(@Path(value = "nextLink", encoded = true) String nextPageLink, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("{nextLink}")
        Observable<Response<ResponseBody>> listAgreementsNext(@Path(value = "nextLink", encoded = true) String nextPageLink, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Lists all top level domains supported for registration.
     * Lists all top level domains supported for registration.
     *
     * @return the PagedList&lt;TopLevelDomainInner&gt; object if successful.
     */
    public PagedList<TopLevelDomainInner> list() {
        ServiceResponse<Page<TopLevelDomainInner>> response = listSinglePageAsync().toBlocking().single();
        return new PagedList<TopLevelDomainInner>(response.getBody()) {
            @Override
            public Page<TopLevelDomainInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().getBody();
            }
        };
    }

    /**
     * Lists all top level domains supported for registration.
     * Lists all top level domains supported for registration.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<TopLevelDomainInner>> listAsync(final ListOperationCallback<TopLevelDomainInner> serviceCallback) {
        return AzureServiceCall.create(
            listSinglePageAsync(),
            new Func1<String, Observable<ServiceResponse<Page<TopLevelDomainInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TopLevelDomainInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Lists all top level domains supported for registration.
     * Lists all top level domains supported for registration.
     *
     * @return the observable to the PagedList&lt;TopLevelDomainInner&gt; object
     */
    public Observable<Page<TopLevelDomainInner>> listAsync() {
        return listWithServiceResponseAsync()
            .map(new Func1<ServiceResponse<Page<TopLevelDomainInner>>, Page<TopLevelDomainInner>>() {
                @Override
                public Page<TopLevelDomainInner> call(ServiceResponse<Page<TopLevelDomainInner>> response) {
                    return response.getBody();
                }
            });
    }

    /**
     * Lists all top level domains supported for registration.
     * Lists all top level domains supported for registration.
     *
     * @return the observable to the PagedList&lt;TopLevelDomainInner&gt; object
     */
    public Observable<ServiceResponse<Page<TopLevelDomainInner>>> listWithServiceResponseAsync() {
        return listSinglePageAsync()
            .concatMap(new Func1<ServiceResponse<Page<TopLevelDomainInner>>, Observable<ServiceResponse<Page<TopLevelDomainInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TopLevelDomainInner>>> call(ServiceResponse<Page<TopLevelDomainInner>> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Lists all top level domains supported for registration.
     * Lists all top level domains supported for registration.
     *
     * @return the PagedList&lt;TopLevelDomainInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<TopLevelDomainInner>>> listSinglePageAsync() {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2016-03-01";
        return service.list(this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<TopLevelDomainInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TopLevelDomainInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<TopLevelDomainInner>> result = listDelegate(response);
                        return Observable.just(new ServiceResponse<Page<TopLevelDomainInner>>(result.getBody(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<TopLevelDomainInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<TopLevelDomainInner>, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<PageImpl<TopLevelDomainInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets details of a top level domain.
     * Gets details of a top level domain.
     *
     * @param name Name of the top level domain
     * @return the TopLevelDomainInner object if successful.
     */
    public TopLevelDomainInner get(String name) {
        return getWithServiceResponseAsync(name).toBlocking().single().getBody();
    }

    /**
     * Gets details of a top level domain.
     * Gets details of a top level domain.
     *
     * @param name Name of the top level domain
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<TopLevelDomainInner> getAsync(String name, final ServiceCallback<TopLevelDomainInner> serviceCallback) {
        return ServiceCall.create(getWithServiceResponseAsync(name), serviceCallback);
    }

    /**
     * Gets details of a top level domain.
     * Gets details of a top level domain.
     *
     * @param name Name of the top level domain
     * @return the observable to the TopLevelDomainInner object
     */
    public Observable<TopLevelDomainInner> getAsync(String name) {
        return getWithServiceResponseAsync(name).map(new Func1<ServiceResponse<TopLevelDomainInner>, TopLevelDomainInner>() {
            @Override
            public TopLevelDomainInner call(ServiceResponse<TopLevelDomainInner> response) {
                return response.getBody();
            }
        });
    }

    /**
     * Gets details of a top level domain.
     * Gets details of a top level domain.
     *
     * @param name Name of the top level domain
     * @return the observable to the TopLevelDomainInner object
     */
    public Observable<ServiceResponse<TopLevelDomainInner>> getWithServiceResponseAsync(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter name is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2016-03-01";
        return service.get(name, this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<TopLevelDomainInner>>>() {
                @Override
                public Observable<ServiceResponse<TopLevelDomainInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<TopLevelDomainInner> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<TopLevelDomainInner> getDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<TopLevelDomainInner, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<TopLevelDomainInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
     * @param name Name of the top level domain
     * @return the PagedList&lt;TldLegalAgreementInner&gt; object if successful.
     */
    public PagedList<TldLegalAgreementInner> listAgreements(final String name) {
        ServiceResponse<Page<TldLegalAgreementInner>> response = listAgreementsSinglePageAsync(name).toBlocking().single();
        return new PagedList<TldLegalAgreementInner>(response.getBody()) {
            @Override
            public Page<TldLegalAgreementInner> nextPage(String nextPageLink) {
                return listAgreementsNextSinglePageAsync(nextPageLink).toBlocking().single().getBody();
            }
        };
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
     * @param name Name of the top level domain
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<TldLegalAgreementInner>> listAgreementsAsync(final String name, final ListOperationCallback<TldLegalAgreementInner> serviceCallback) {
        return AzureServiceCall.create(
            listAgreementsSinglePageAsync(name),
            new Func1<String, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(String nextPageLink) {
                    return listAgreementsNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
     * @param name Name of the top level domain
     * @return the observable to the PagedList&lt;TldLegalAgreementInner&gt; object
     */
    public Observable<Page<TldLegalAgreementInner>> listAgreementsAsync(final String name) {
        return listAgreementsWithServiceResponseAsync(name)
            .map(new Func1<ServiceResponse<Page<TldLegalAgreementInner>>, Page<TldLegalAgreementInner>>() {
                @Override
                public Page<TldLegalAgreementInner> call(ServiceResponse<Page<TldLegalAgreementInner>> response) {
                    return response.getBody();
                }
            });
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
     * @param name Name of the top level domain
     * @return the observable to the PagedList&lt;TldLegalAgreementInner&gt; object
     */
    public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> listAgreementsWithServiceResponseAsync(final String name) {
        return listAgreementsSinglePageAsync(name)
            .concatMap(new Func1<ServiceResponse<Page<TldLegalAgreementInner>>, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(ServiceResponse<Page<TldLegalAgreementInner>> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listAgreementsNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
     * @param name Name of the top level domain
     * @return the PagedList&lt;TldLegalAgreementInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> listAgreementsSinglePageAsync(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter name is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2016-03-01";
        final Boolean includePrivacy = null;
        TopLevelDomainAgreementOption agreementOption = new TopLevelDomainAgreementOption();
        agreementOption.withIncludePrivacy(null);
        return service.listAgreements(name, this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), agreementOption, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<TldLegalAgreementInner>> result = listAgreementsDelegate(response);
                        return Observable.just(new ServiceResponse<Page<TldLegalAgreementInner>>(result.getBody(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
     * @param name Name of the top level domain
     * @param includePrivacy If true then the list of agreements will inclue agreements for domain privacy as well.
     * @return the PagedList&lt;TldLegalAgreementInner&gt; object if successful.
     */
    public PagedList<TldLegalAgreementInner> listAgreements(final String name, final Boolean includePrivacy) {
        ServiceResponse<Page<TldLegalAgreementInner>> response = listAgreementsSinglePageAsync(name, includePrivacy).toBlocking().single();
        return new PagedList<TldLegalAgreementInner>(response.getBody()) {
            @Override
            public Page<TldLegalAgreementInner> nextPage(String nextPageLink) {
                return listAgreementsNextSinglePageAsync(nextPageLink).toBlocking().single().getBody();
            }
        };
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
     * @param name Name of the top level domain
     * @param includePrivacy If true then the list of agreements will inclue agreements for domain privacy as well.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<TldLegalAgreementInner>> listAgreementsAsync(final String name, final Boolean includePrivacy, final ListOperationCallback<TldLegalAgreementInner> serviceCallback) {
        return AzureServiceCall.create(
            listAgreementsSinglePageAsync(name, includePrivacy),
            new Func1<String, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(String nextPageLink) {
                    return listAgreementsNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
     * @param name Name of the top level domain
     * @param includePrivacy If true then the list of agreements will inclue agreements for domain privacy as well.
     * @return the observable to the PagedList&lt;TldLegalAgreementInner&gt; object
     */
    public Observable<Page<TldLegalAgreementInner>> listAgreementsAsync(final String name, final Boolean includePrivacy) {
        return listAgreementsWithServiceResponseAsync(name, includePrivacy)
            .map(new Func1<ServiceResponse<Page<TldLegalAgreementInner>>, Page<TldLegalAgreementInner>>() {
                @Override
                public Page<TldLegalAgreementInner> call(ServiceResponse<Page<TldLegalAgreementInner>> response) {
                    return response.getBody();
                }
            });
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
     * @param name Name of the top level domain
     * @param includePrivacy If true then the list of agreements will inclue agreements for domain privacy as well.
     * @return the observable to the PagedList&lt;TldLegalAgreementInner&gt; object
     */
    public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> listAgreementsWithServiceResponseAsync(final String name, final Boolean includePrivacy) {
        return listAgreementsSinglePageAsync(name, includePrivacy)
            .concatMap(new Func1<ServiceResponse<Page<TldLegalAgreementInner>>, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(ServiceResponse<Page<TldLegalAgreementInner>> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listAgreementsNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
    ServiceResponse<PageImpl<TldLegalAgreementInner>> * @param name Name of the top level domain
    ServiceResponse<PageImpl<TldLegalAgreementInner>> * @param includePrivacy If true then the list of agreements will inclue agreements for domain privacy as well.
     * @return the PagedList&lt;TldLegalAgreementInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> listAgreementsSinglePageAsync(final String name, final Boolean includePrivacy) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter name is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2016-03-01";
        TopLevelDomainAgreementOption agreementOption = new TopLevelDomainAgreementOption();
        agreementOption.withIncludePrivacy(includePrivacy);
        return service.listAgreements(name, this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), agreementOption, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<TldLegalAgreementInner>> result = listAgreementsDelegate(response);
                        return Observable.just(new ServiceResponse<Page<TldLegalAgreementInner>>(result.getBody(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<TldLegalAgreementInner>> listAgreementsDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<TldLegalAgreementInner>, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<PageImpl<TldLegalAgreementInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Lists all top level domains supported for registration.
     * Lists all top level domains supported for registration.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the PagedList&lt;TopLevelDomainInner&gt; object if successful.
     */
    public PagedList<TopLevelDomainInner> listNext(final String nextPageLink) {
        ServiceResponse<Page<TopLevelDomainInner>> response = listNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<TopLevelDomainInner>(response.getBody()) {
            @Override
            public Page<TopLevelDomainInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().getBody();
            }
        };
    }

    /**
     * Lists all top level domains supported for registration.
     * Lists all top level domains supported for registration.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<TopLevelDomainInner>> listNextAsync(final String nextPageLink, final ServiceCall<List<TopLevelDomainInner>> serviceCall, final ListOperationCallback<TopLevelDomainInner> serviceCallback) {
        return AzureServiceCall.create(
            listNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<TopLevelDomainInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TopLevelDomainInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Lists all top level domains supported for registration.
     * Lists all top level domains supported for registration.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the observable to the PagedList&lt;TopLevelDomainInner&gt; object
     */
    public Observable<Page<TopLevelDomainInner>> listNextAsync(final String nextPageLink) {
        return listNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<TopLevelDomainInner>>, Page<TopLevelDomainInner>>() {
                @Override
                public Page<TopLevelDomainInner> call(ServiceResponse<Page<TopLevelDomainInner>> response) {
                    return response.getBody();
                }
            });
    }

    /**
     * Lists all top level domains supported for registration.
     * Lists all top level domains supported for registration.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the observable to the PagedList&lt;TopLevelDomainInner&gt; object
     */
    public Observable<ServiceResponse<Page<TopLevelDomainInner>>> listNextWithServiceResponseAsync(final String nextPageLink) {
        return listNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<TopLevelDomainInner>>, Observable<ServiceResponse<Page<TopLevelDomainInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TopLevelDomainInner>>> call(ServiceResponse<Page<TopLevelDomainInner>> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Lists all top level domains supported for registration.
     * Lists all top level domains supported for registration.
     *
    ServiceResponse<PageImpl<TopLevelDomainInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the PagedList&lt;TopLevelDomainInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<TopLevelDomainInner>>> listNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        return service.listNext(nextPageLink, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<TopLevelDomainInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TopLevelDomainInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<TopLevelDomainInner>> result = listNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<TopLevelDomainInner>>(result.getBody(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<TopLevelDomainInner>> listNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<TopLevelDomainInner>, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<PageImpl<TopLevelDomainInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the PagedList&lt;TldLegalAgreementInner&gt; object if successful.
     */
    public PagedList<TldLegalAgreementInner> listAgreementsNext(final String nextPageLink) {
        ServiceResponse<Page<TldLegalAgreementInner>> response = listAgreementsNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<TldLegalAgreementInner>(response.getBody()) {
            @Override
            public Page<TldLegalAgreementInner> nextPage(String nextPageLink) {
                return listAgreementsNextSinglePageAsync(nextPageLink).toBlocking().single().getBody();
            }
        };
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<TldLegalAgreementInner>> listAgreementsNextAsync(final String nextPageLink, final ServiceCall<List<TldLegalAgreementInner>> serviceCall, final ListOperationCallback<TldLegalAgreementInner> serviceCallback) {
        return AzureServiceCall.create(
            listAgreementsNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(String nextPageLink) {
                    return listAgreementsNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the observable to the PagedList&lt;TldLegalAgreementInner&gt; object
     */
    public Observable<Page<TldLegalAgreementInner>> listAgreementsNextAsync(final String nextPageLink) {
        return listAgreementsNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<TldLegalAgreementInner>>, Page<TldLegalAgreementInner>>() {
                @Override
                public Page<TldLegalAgreementInner> call(ServiceResponse<Page<TldLegalAgreementInner>> response) {
                    return response.getBody();
                }
            });
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the observable to the PagedList&lt;TldLegalAgreementInner&gt; object
     */
    public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> listAgreementsNextWithServiceResponseAsync(final String nextPageLink) {
        return listAgreementsNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<TldLegalAgreementInner>>, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(ServiceResponse<Page<TldLegalAgreementInner>> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listAgreementsNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Lists legal agreements that user needs to accept before purchasing domain.
     * Lists legal agreements that user needs to accept before purchasing domain.
     *
    ServiceResponse<PageImpl<TldLegalAgreementInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the PagedList&lt;TldLegalAgreementInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> listAgreementsNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        return service.listAgreementsNext(nextPageLink, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<TldLegalAgreementInner>> result = listAgreementsNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<TldLegalAgreementInner>>(result.getBody(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<TldLegalAgreementInner>> listAgreementsNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<TldLegalAgreementInner>, CloudException>(this.client.mapperAdapter())
                .register(200, new TypeToken<PageImpl<TldLegalAgreementInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}