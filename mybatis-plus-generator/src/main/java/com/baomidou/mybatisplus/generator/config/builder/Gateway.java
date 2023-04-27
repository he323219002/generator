/*
 * Copyright (c) 2011-2021, baomidou (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.generator.config.builder;

import com.baomidou.mybatisplus.generator.ITemplate;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.function.ConverterFileName;
import com.baomidou.mybatisplus.generator.util.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Service属性配置
 *
 * @author nieqiurong 2020/10/11.
 * @since 3.5.0
 */
public class Gateway implements ITemplate {

    private final static Logger LOGGER = LoggerFactory.getLogger(Gateway.class);

    private Gateway() {
    }

    /**
     * 自定义继承的Service类全称，带包名
     */
    private String superGatewayClass;

    /**
     * 自定义继承的ServiceImpl类全称，带包名
     */
    private String superGatewayImplClass;

    @NotNull
    public String getSuperGatewayClass() {
        return superGatewayClass;
    }

    @NotNull
    public String getSuperGatewayImplClass() {
        return superGatewayImplClass;
    }

    /**
     * 转换输出Service文件名称
     *
     * @since 3.5.0
     */
    private ConverterFileName converterGatewayFileName = (entityName -> entityName + ConstVal.GATEWAY);

    /**
     * 转换输出ServiceImpl文件名称
     *
     * @since 3.5.0
     */
    private ConverterFileName converterGatewayImplFileName = (entityName -> entityName + ConstVal.GATEWAY_IMPL);

    /**
     * 是否覆盖已有文件（默认 false）
     *
     * @since 3.5.2
     */
    private boolean fileOverride;

    @NotNull
    public ConverterFileName getConverterGatewayFileName() {
        return converterGatewayFileName;
    }

    @NotNull
    public ConverterFileName getConverterGatewayImplFileName() {
        return converterGatewayImplFileName;
    }

    public boolean isFileOverride() {
        return fileOverride;
    }

    @Override
    @NotNull
    public Map<String, Object> renderData(@NotNull TableInfo tableInfo) {
        Map<String, Object> data = new HashMap<>();
//        data.put("superServiceClassPackage", this.superServiceClass);
//        data.put("superServiceClass", ClassUtils.getSimpleName(this.superServiceClass));
//        data.put("superServiceImplClassPackage", this.superServiceImplClass);
//        data.put("superServiceImplClass", ClassUtils.getSimpleName(this.superServiceImplClass));
        return data;
    }

    public static class Builder extends BaseBuilder {

        private final Gateway gateway = new Gateway();

        public Builder(@NotNull StrategyConfig strategyConfig) {
            super(strategyConfig);
        }

        /**
         * Service接口父类
         *
         * @param clazz 类
         * @return this
         */
        public Builder superGatewayClass(@NotNull Class<?> clazz) {
            return superGatewayClass(clazz.getName());
        }

        /**
         * Service接口父类
         *
         * @param superGatewayClass 类名
         * @return this
         */
        public Builder superGatewayClass(@NotNull String superGatewayClass) {
            this.gateway.superGatewayClass = superGatewayClass;
            return this;
        }

        /**
         * Service实现类父类
         *
         * @param clazz 类
         * @return this
         */
        public Builder superGatewayImplClass(@NotNull Class<?> clazz) {
            return superGatewayImplClass(clazz.getName());
        }

        /**
         * Service实现类父类
         *
         * @param superGatewayImplClass 类名
         * @return this
         */
        public Builder superGatewayImplClass(@NotNull String superGatewayImplClass) {
            this.gateway.superGatewayImplClass = superGatewayImplClass;
            return this;
        }

        /**
         * 转换输出service接口文件名称
         *
         * @param converter 　转换处理
         * @return this
         * @since 3.5.0
         */
        public Builder convertGatewayFileName(@NotNull ConverterFileName converter) {
            this.gateway.converterGatewayFileName = converter;
            return this;
        }

        /**
         * 转换输出service实现类文件名称
         *
         * @param converter 　转换处理
         * @return this
         * @since 3.5.0
         */
        public Builder convertGatewayImplFileName(@NotNull ConverterFileName converter) {
            this.gateway.converterGatewayImplFileName = converter;
            return this;
        }

        /**
         * 格式化service接口文件名称
         *
         * @param format 　格式
         * @return this
         * @since 3.5.0
         */
        public Builder formatGatewayFileName(@NotNull String format) {
            return convertGatewayFileName((entityName) -> String.format(format, entityName));
        }

        /**
         * 格式化service实现类文件名称
         *
         * @param format 　格式
         * @return this
         * @since 3.5.0
         */
        public Builder formatGatewayImplFileName(@NotNull String format) {
            return convertGatewayImplFileName((entityName) -> String.format(format, entityName));
        }

        /**
         * 覆盖已有文件（该方法后续会删除，替代方法为enableFileOverride方法）
         *
         * @see #enableFileOverride()
         */
        @Deprecated
        public Builder fileOverride() {
            LOGGER.warn("fileOverride方法后续会删除，替代方法为enableFileOverride方法");
            this.gateway.fileOverride = true;
            return this;
        }

        /**
         * 覆盖已有文件
         */
        public Builder enableFileOverride() {
            this.gateway.fileOverride = true;
            return this;
        }

        @NotNull
        public Gateway get() {
            return this.gateway;
        }
    }
}
