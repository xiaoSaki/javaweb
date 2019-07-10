package com.lingnan.examsys.common.constant;

public class MyType {
	/**
	 * 章节测试题目数量:
	 * 注意：在数据库内的对应章节的题目数量必须大于此常量，否则出现题目重复
	 */
	public static final int CHAPTER_TEST_NUM = 10;
	/**
	 * 章节测试时间
	 */
	public static final int CHAPTER_TEST_TIME = 1800000;
	/**
	 * 接近章节测试结束时间时可允许的最大延时
	 */
	public static final int CHAPTER_TEST_LAST = 5000;
	/**
	 * 章节测试封锁时间限时
	 */
	public static final int CHAPTER_TEST_LUCK = 1800000;
	/**
	 * 章节测试的名称
	 */
	public static final String ChapterTestName(int chapter) {
		return "第"+chapter+"章章节测试";
	}
	/**
	 * 考试题目数量
	 */
	public static final int EXAM_TEST_NUM = 10;
	/**
	 * 考试测试时间
	 */
	public static final int EXAM_TEST_TIME = 3600000;
	/**
	 * 接近考试结束时间时可允许的最大延时
	 */
	public static final int EXAM_TEST_LAST = 5000;
	/**
	 * 考试封锁时间限时
	 */
	public static final int EXAM_TEST_LUCK = 1800000;
}
