package ru.parfenov.leetcode.practice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CodingInterview {

//        @Transactional
//        public void save(Person person) {
//            person.setAge(33);
//        }
//
//
//        public String getUrlFromDataProvider(DataProvider dataProvider){
//
//            return switch (dataProvider.getDataProviderSourceType()){
//                case ORACLE -> {
//                    return dataProvider.getConnectionType()
//                            + ":" + dataProvider.getSourceType().getDriverConnectionType() + ":@"
//                            + dataProvider.getServerName() + ":" + dataProvider.getPort()
//                            + dataProvider.getAdditionalProperties();
//                };
//                case POSTGRES -> {
//                    return dataProvider.getConnectionType()
//                            + ":" + dataProvider.getSourceType().getDriverConnectionType() + "://"
//                            + dataProvider.getServerName() + ":" + dataProvider.getPort()
//                            + dataProvider.getAdditionalProperties();
//                };
//            };
//        }
//
//
//    }
//
//    @Service
//    public class PostgresBuildUrlService implements DataProviderUrlBuilderService {
//
//        @Override
//        public String getUrlFromDataProvider(DataProvider dataProvider) {
//            return dataProvider.getConnectionType()
//                    + ":" + dataProvider.getSourceType().getDriverConnectionType() + ":@"
//                    + dataProvider.getServerName() + ":" + dataProvider.getPort()
//                    + dataProvider.getAdditionalProperties();
//        }
//
//        @Override
//        public DataProviderSourceType getDataProviderSourceType(){
//            return POSTGRES;
//        }
//
//    }
//
//    @Service
//    public class OracleBuildUrlService implements DataProviderUrlBuilderService {
//
//        @Override
//        public String getUrlFromDataProvider(DataProvider dataProvider) {
//            return dataProvider.getConnectionType()
//                    + ":" + dataProvider.getSourceType().getDriverConnectionType() + ":@"
//                    + dataProvider.getServerName() + ":" + dataProvider.getPort()
//                    + dataProvider.getAdditionalProperties();
//        }
//
//        @Override
//        public DataProviderSourceType getDataProviderSourceType(){
//            return ORACLE;
//        }
//
//    }
//
//    public interface DataProviderUrlBuilderService {
//
//        String getUrlFromDataProvider(DataProvider dataProvider);
//
//        DataProviderSourceType getDataProviderSourceType();
//
//    }
//
//
//    @Service
//    @RequiredArgsConstructor
//    public class ServiceProvider {
//
//        private final Map<DataProviderSourceType,DataProviderUrlBuilderService> map;
//
//
//        public String getDataProviderSourceType(DataProvider dataProvider) {
//            return map.get(dataProvider.getDataProviderSourceType()).getUrlFromDataProvider(dataProvider);
//        }
//
//
//
//    }
//
//    @Configuration
//    public class Config {
//        @Bean
//        public Map<DataProviderSourceType,DataProviderUrlBuilderService> getDataProviderServiceMap(List<DataProviderUrlBuilderService> serviceList) {
//            return  serviceList.stream().collect(Collectors.toMap(DataProviderUrlBuilderService::DataProviderSourceType, Function.identity());
//        }
//
//    }
//
//
//    @Service
//    @RequiredArgsConstructor
//    public class FabricProvider  {
//
//        private final List<DataProviderUrlBuilderService> serviceList;
//
//
//        public  Map<DataProviderSourceType,DataProviderUrlBuilderService> getDataProviderServiceMap(DataProvider dataProvider) {
//            return  serviceList.stream()
//              .collect(Collectors.toMap(DataProviderUrlBuilderService::DataProviderSourceType, Function.identity());
//        }




}
