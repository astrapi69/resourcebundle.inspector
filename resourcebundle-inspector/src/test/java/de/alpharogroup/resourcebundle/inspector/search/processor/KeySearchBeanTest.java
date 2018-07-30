/**
 * The MIT License
 *
 * Copyright (C) 2012 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.resourcebundle.inspector.search.processor;

import static org.testng.AssertJUnit.assertEquals;

import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;
import org.testng.annotations.Test;

import de.alpharogroup.collections.pairs.KeyValuesPair;
import de.alpharogroup.evaluate.object.evaluators.EqualsHashCodeAndToStringEvaluator;
import de.alpharogroup.meanbean.factories.FileFactory;
import de.alpharogroup.meanbean.factories.LocaleFactory;
import de.alpharogroup.meanbean.factories.StringArrayFactory;

/**
 * The unit test class for the class {@link KeySearchBean}.
 */
public class KeySearchBeanTest
{

	/**
	 * Test method for {@link KeyValuesPair#equals(Object)} , {@link KeyValuesPair#hashCode()} and
	 * {@link KeyValuesPair#toString()}
	 */
	@Test
	public void testEqualsHashcodeAndToString()
	{
		boolean expected;
		boolean actual;

		final KeySearchBean first = KeySearchBean.builder().build();

		final KeySearchBean second = new KeySearchBean();

		final KeySearchBean third = KeySearchBean.builder().build();
		final KeySearchBean fourth = KeySearchBean.builder().build();

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsHashcodeAndToString(first, second,
			third, fourth);
		expected = true;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link KeySearchBean}
	 */
	@Test
	public void testWithBeanTester()
	{
		Configuration configuration = new ConfigurationBuilder()
			.overrideFactory("fileExtensions", new StringArrayFactory())
			.overrideFactory("searchDir", new FileFactory())
			.overrideFactory("locale", new LocaleFactory()).build();
		final BeanTester beanTester = new BeanTester();
		beanTester.addCustomConfiguration(KeySearchBean.class, configuration);
		beanTester.testBean(KeySearchBean.class);

	}

}
