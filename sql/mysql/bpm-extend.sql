/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : ruoyi-vue-pro

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 14/09/2025 23:31:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bpm_category
-- ----------------------------
DROP TABLE IF EXISTS `bpm_category`;
CREATE TABLE `bpm_category` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '分类编号',
  `name` varchar(255) NOT NULL COMMENT '分类名',
  `code` varchar(255) NOT NULL COMMENT '分类标志',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分类描述',
  `status` tinyint NOT NULL COMMENT '分类状态(0：开启 1：关闭)',
  `sort` int NOT NULL DEFAULT '0' COMMENT '分类排序',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT '0' COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Bpm流程分类';

-- ----------------------------
-- Table structure for bpm_form
-- ----------------------------
DROP TABLE IF EXISTS `bpm_form`;
CREATE TABLE `bpm_form` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) NOT NULL COMMENT '表单名',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态（0：开启 1：关闭）',
  `conf` text NOT NULL COMMENT '表单的配置',
  `fields` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '表单项的数组',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT '0' COMMENT '租户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='bpm工作流的表单定义';

-- ----------------------------
-- Table structure for bpm_process_definition_info
-- ----------------------------
DROP TABLE IF EXISTS `bpm_process_definition_info`;
CREATE TABLE `bpm_process_definition_info` (
   `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
   `process_definition_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '流程定义的编号',
   `model_id` varchar(64) DEFAULT NULL COMMENT '流程模型的编号',
   `model_type` tinyint DEFAULT NULL COMMENT '流程模型的类型',
   `category` varchar(255) DEFAULT NULL COMMENT '流程分类的编码',
   `icon` varchar(255) DEFAULT NULL COMMENT '图标',
   `description` varchar(500) DEFAULT NULL COMMENT '描述',
   `form_type` tinyint DEFAULT NULL COMMENT '表单类型',
   `form_id` bigint DEFAULT NULL COMMENT '动态表单编号',
   `form_conf` text COMMENT '表单的配置',
   `form_fields` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '表单项的数组',
   `form_custom_create_path` varchar(100) DEFAULT NULL COMMENT '自定义表单的提交路径，使用 Vue 的路由地址',
   `form_custom_view_path` varchar(100) DEFAULT NULL COMMENT '自定义表单的查看路径，使用 Vue 的路由地址',
   `simple_model` text COMMENT 'SIMPLE 设计器模型数据 json 格式',
   `visible` bit(1) DEFAULT NULL COMMENT '是否可见',
   `sort` bigint DEFAULT NULL COMMENT '排序值',
   `start_user_ids` varchar(500) DEFAULT NULL COMMENT '可发起用户编号数组',
   `start_dept_ids` varchar(500) DEFAULT NULL COMMENT '可发起部门编号数组',
   `manager_user_ids` varchar(500) DEFAULT NULL COMMENT '可管理用户编号数组',
   `allow_cancel_running_process` bit(1) DEFAULT NULL COMMENT '是否允许撤销审批中的申请',
   `allow_withdraw_task` bit(1) DEFAULT NULL COMMENT '是否允许审批人撤回任务',
   `process_id_rule` varchar(500) DEFAULT NULL COMMENT '流程 ID 规则',
   `auto_approval_type` tinyint DEFAULT NULL COMMENT '自动去重类型',
   `title_setting` varchar(500) DEFAULT NULL COMMENT '标题设置',
   `summary_setting` varchar(1000) DEFAULT NULL COMMENT '摘要设置',
   `process_before_trigger_setting` text COMMENT '流程前置通知设置',
   `process_after_trigger_setting` text COMMENT '流程后置通知设置',
   `task_before_trigger_setting` text COMMENT '任务前置通知设置',
   `task_after_trigger_setting` text COMMENT '任务后置通知设置',
   `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
   `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
   `tenant_id` bigint NOT NULL DEFAULT '0' COMMENT '租户编号',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='bpm流程定义扩展表';

-- ----------------------------
-- Table structure for bpm_user_group
-- ----------------------------
DROP TABLE IF EXISTS `bpm_user_group`;
CREATE TABLE `bpm_user_group` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号，自增',
  `name` varchar(255) NOT NULL COMMENT '组名',
  `description` varchar(500) DEFAULT NULL,
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态(0：开启 1：关闭)',
  `user_ids` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '成员用户编号数组',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT '0' COMMENT '租户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='bpm用户组';


-- ----------------------------
-- Table structure for bpm_process_expression
-- ----------------------------
DROP TABLE IF EXISTS `bpm_process_expression`;
CREATE TABLE `bpm_process_expression` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '表达式名字',
  `status` tinyint NOT NULL COMMENT '表达式状态',
  `expression` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '表达式',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT '0' COMMENT '租户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='BPM 流程表达式';


-- ----------------------------
-- Table structure for bpm_process_listener
-- ----------------------------
DROP TABLE IF EXISTS `bpm_process_listener`;
CREATE TABLE `bpm_process_listener` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键 ID',
    `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '监听器名字',
    `status` tinyint NOT NULL COMMENT '状态',
    `type` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '监听类型',
    `event` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '监听事件',
    `value_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '值类型',
    `value` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '值',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint NOT NULL DEFAULT '0' COMMENT '租户编号',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='BPM 流程监听器';



SET FOREIGN_KEY_CHECKS = 1;
