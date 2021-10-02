package com.example.samplecountriesapp.root.countries.list

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.samplecountriesapp.R
import com.example.samplecountriesapp.root.countries.list.data.ApiInterface
import com.example.samplecountriesapp.root.countries.list.data.repository.CharactersRepository
import com.example.samplecountriesapp.root.countries.list.data.repository.Repository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton


class CountriesListBuilder (dependency: ParentComponent) :
    ViewBuilder<CountriesListView, CountriesListRouter, CountriesListBuilder.ParentComponent>(
        dependency
    ) {
    fun build(parentViewGroup: ViewGroup): CountriesListRouter {
        val view = createView(parentViewGroup)
        val component = DaggerCountriesListBuilder_Component.builder()
            .parentComponent(dependency)
            .view(view)
            .interactor(CountriesListInteractors())
            .build()
        return component.countriesListRouter()
    }

    override fun inflateView(
        inflater: LayoutInflater,
        parentViewGroup: ViewGroup
    ): CountriesListView {
        return inflater.inflate(
            R.layout.countries_list_rib,
            parentViewGroup,
            false
        ) as CountriesListView
    }

    interface ParentComponent {

        fun context(): Context
    }

    @dagger.Module
    abstract class Module {

        @CoinListScope
        @Binds
        internal abstract fun presenter(view: CountriesListView): CountriesListInteractors.CountriesListPresenter

        @dagger.Module
        companion object {
            @Provides
            @Singleton
            internal fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
                return Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl("https://rickandmortyapi.com/api/")
                    .client(okHttpClient)
                    .build()
            }


            /*
             * We need the MovieApiService module.
             * For this, We need the Retrofit object, Gson, Cache and OkHttpClient .
             * So we will define the providers for these objects here in this module.
             *
             * */
            @Provides
            @Singleton
            internal fun provideApiService(retrofit: Retrofit): ApiInterface {
                return retrofit.create(ApiInterface::class.java)
            }
            @Provides
            @Singleton
            internal fun provideGson(): Gson {
                val gsonBuilder = GsonBuilder()
                return gsonBuilder.create()
            }


            /*
             * The method returns the Cache object
             * */
            @Provides
            @Singleton
            internal fun provideCache(application: Application): Cache {
                val cacheSize = (10 * 1024 * 1024).toLong() // 10 MB
                val httpCacheDirectory = File(application.cacheDir, "http-cache")
                return Cache(httpCacheDirectory, cacheSize)
            }


            /*
             * The method returns the Okhttp object
             * */
            @Provides
            @Singleton
            internal fun provideOkhttpClient(cache: Cache): OkHttpClient {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY

                val httpClient = OkHttpClient.Builder()
                httpClient.cache(cache)
                httpClient.addInterceptor(logging)
                httpClient.connectTimeout(30, TimeUnit.SECONDS)
                httpClient.readTimeout(30, TimeUnit.SECONDS)
                return httpClient.build()
            }


            /*
             * The method returns the Retrofit object
             * */


            @Provides
            @Singleton
            fun provideRepository(impl: CharactersRepository): Repository = impl

            /*@CoinListScope
            @Provides
            @JvmStatic
            fun provideHttpClient(context: Context): OkHttpClient {

                val cacheSize = 10 * 1024 * 1024L // 10 MB
                val cacheDirectory = File(context.cacheDir.absolutePath, "CountriesCache")
                val cache = Cache(cacheDirectory, cacheSize)

                return OkHttpClient.Builder()
                    .cache(cache)
                    .build()
            }*/

            /*@CoinListScope
            @Provides
            @JvmStatic
            fun provideCoinListNetworkRepository(coinService: ApiInterface): CharactersRepository {
                return CharactersRepository(coinService)
            }*/
           /* @CoinListScope
            @Provides
            @JvmStatic
            fun provideCharService(okHttpClient: OkHttpClient): ApiInterface {
                return ApiInterface(okHttpClient)
            }

            @CoinListScope
            @Provides
            @JvmStatic
            fun provideCoinListNetworkRepository(coinService: ApiInterface): CharactersRepository {
                return CharactersRepository(coinService)
            }*/

            /*

             @CoinListScope
             @Provides
             @JvmStatic
             fun provideCoinListLocalRepository(boxStore: BoxStore): CoinListLocalRepository {
                 return CoinListLocalRepository(boxStore)
             }
 */
            @CoinListScope
            @Provides
            @JvmStatic
            internal fun router(
                component: Component,
                view: CountriesListView,
                interactor: CountriesListInteractors
            ): CountriesListRouter {
                return CountriesListRouter(view, interactor, component)
            }
        }
    }

    @CoinListScope
    @dagger.Component(modules = [Module::class], dependencies = [ParentComponent::class])
    interface Component : InteractorBaseComponent<CountriesListInteractors>, BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: CountriesListInteractors): Builder

            @BindsInstance
            fun view(view: CountriesListView): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }
    }

    interface BuilderComponent {
        fun countriesListRouter(): CountriesListRouter
    }

    @Scope
    @Retention(AnnotationRetention.RUNTIME)
    internal annotation class CoinListScope

}
