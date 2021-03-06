/* Copyright (c) 2013-2014, Cornell University
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of HyperDex nor the names of its contributors may be
 *       used to endorse or promote products derived from this software without
 *       specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/* This file is generated by bindings/java.py */

package org.hyperdex.client;

import java.util.Map;
import java.util.HashMap;

public class Client
{
    static
    {
        System.loadLibrary("hyperdex-client-java");
        initialize();
    }

    private long ptr = 0;
    private Map<Long, Operation> ops = null;

    public Client(String host, Integer port)
    {
        _create(host, port.intValue());
        this.ops = new HashMap<Long, Operation>();
    }

    public Client(String host, int port)
    {
        _create(host, port);
        this.ops = new HashMap<Long, Operation>();
    }

    protected void finalize() throws Throwable
    {
        try
        {
            destroy();
        }
        finally
        {
            super.finalize();
        }
    }

    public synchronized void destroy()
    {
        if (ptr != 0)
        {
            _destroy();
            ptr = 0;
        }
    }

    /* utilities */
    public Operation loop()
    {
        long ret = inner_loop();
        Operation o = ops.get(ret);

        if (o != null)
        {
            o.callback();
        }

        return o;
    }

    /* cached IDs */
    private static native void initialize();
    private static native void terminate();
    /* ctor/dtor */
    private native void _create(String host, int port);
    private native void _destroy();
    /* utilities */
    private native long inner_loop();
    private void add_op(long l, Operation op)
    {
        ops.put(l, op);
    }
    private void remove_op(long l)
    {
        ops.remove(l);
    }
    /* operations */
    public native Deferred async_get(String spacename, Object key) throws HyperDexClientException;
    public Map<String, Object> get(String spacename, Object key) throws HyperDexClientException
    {
        return (Map<String, Object>) async_get(spacename, key).waitForIt();
    }

    public native Deferred async_put(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean put(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_put(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_put(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_put(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_put(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_put_if_not_exist(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean put_if_not_exist(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_put_if_not_exist(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_del(String spacename, Object key) throws HyperDexClientException;
    public Boolean del(String spacename, Object key) throws HyperDexClientException
    {
        return (Boolean) async_del(spacename, key).waitForIt();
    }

    public native Deferred async_cond_del(String spacename, Object key, Map<String, Object> predicates) throws HyperDexClientException;
    public Boolean cond_del(String spacename, Object key, Map<String, Object> predicates) throws HyperDexClientException
    {
        return (Boolean) async_cond_del(spacename, key, predicates).waitForIt();
    }

    public native Deferred async_atomic_add(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean atomic_add(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_atomic_add(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_atomic_add(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_atomic_add(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_atomic_add(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_atomic_sub(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean atomic_sub(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_atomic_sub(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_atomic_sub(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_atomic_sub(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_atomic_sub(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_atomic_mul(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean atomic_mul(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_atomic_mul(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_atomic_mul(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_atomic_mul(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_atomic_mul(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_atomic_div(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean atomic_div(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_atomic_div(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_atomic_div(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_atomic_div(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_atomic_div(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_atomic_mod(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean atomic_mod(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_atomic_mod(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_atomic_mod(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_atomic_mod(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_atomic_mod(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_atomic_and(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean atomic_and(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_atomic_and(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_atomic_and(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_atomic_and(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_atomic_and(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_atomic_or(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean atomic_or(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_atomic_or(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_atomic_or(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_atomic_or(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_atomic_or(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_atomic_xor(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean atomic_xor(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_atomic_xor(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_atomic_xor(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_atomic_xor(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_atomic_xor(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_string_prepend(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean string_prepend(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_string_prepend(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_string_prepend(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_string_prepend(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_string_prepend(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_string_append(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean string_append(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_string_append(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_string_append(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_string_append(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_string_append(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_list_lpush(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean list_lpush(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_list_lpush(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_list_lpush(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_list_lpush(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_list_lpush(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_list_rpush(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean list_rpush(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_list_rpush(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_list_rpush(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_list_rpush(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_list_rpush(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_set_add(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean set_add(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_set_add(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_set_add(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_set_add(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_set_add(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_set_remove(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean set_remove(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_set_remove(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_set_remove(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_set_remove(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_set_remove(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_set_intersect(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean set_intersect(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_set_intersect(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_set_intersect(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_set_intersect(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_set_intersect(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_set_union(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean set_union(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_set_union(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_set_union(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_set_union(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_set_union(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_map_add(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean map_add(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_map_add(spacename, key, mapattributes).waitForIt();
    }

    public native Deferred async_cond_map_add(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean cond_map_add(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_map_add(spacename, key, predicates, mapattributes).waitForIt();
    }

    public native Deferred async_map_remove(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean map_remove(String spacename, Object key, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_map_remove(spacename, key, attributes).waitForIt();
    }

    public native Deferred async_cond_map_remove(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException;
    public Boolean cond_map_remove(String spacename, Object key, Map<String, Object> predicates, Map<String, Object> attributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_map_remove(spacename, key, predicates, attributes).waitForIt();
    }

    public native Deferred async_map_atomic_add(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean map_atomic_add(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_map_atomic_add(spacename, key, mapattributes).waitForIt();
    }

    public native Deferred async_cond_map_atomic_add(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean cond_map_atomic_add(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_map_atomic_add(spacename, key, predicates, mapattributes).waitForIt();
    }

    public native Deferred async_map_atomic_sub(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean map_atomic_sub(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_map_atomic_sub(spacename, key, mapattributes).waitForIt();
    }

    public native Deferred async_cond_map_atomic_sub(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean cond_map_atomic_sub(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_map_atomic_sub(spacename, key, predicates, mapattributes).waitForIt();
    }

    public native Deferred async_map_atomic_mul(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean map_atomic_mul(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_map_atomic_mul(spacename, key, mapattributes).waitForIt();
    }

    public native Deferred async_cond_map_atomic_mul(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean cond_map_atomic_mul(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_map_atomic_mul(spacename, key, predicates, mapattributes).waitForIt();
    }

    public native Deferred async_map_atomic_div(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean map_atomic_div(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_map_atomic_div(spacename, key, mapattributes).waitForIt();
    }

    public native Deferred async_cond_map_atomic_div(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean cond_map_atomic_div(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_map_atomic_div(spacename, key, predicates, mapattributes).waitForIt();
    }

    public native Deferred async_map_atomic_mod(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean map_atomic_mod(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_map_atomic_mod(spacename, key, mapattributes).waitForIt();
    }

    public native Deferred async_cond_map_atomic_mod(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean cond_map_atomic_mod(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_map_atomic_mod(spacename, key, predicates, mapattributes).waitForIt();
    }

    public native Deferred async_map_atomic_and(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean map_atomic_and(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_map_atomic_and(spacename, key, mapattributes).waitForIt();
    }

    public native Deferred async_cond_map_atomic_and(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean cond_map_atomic_and(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_map_atomic_and(spacename, key, predicates, mapattributes).waitForIt();
    }

    public native Deferred async_map_atomic_or(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean map_atomic_or(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_map_atomic_or(spacename, key, mapattributes).waitForIt();
    }

    public native Deferred async_cond_map_atomic_or(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean cond_map_atomic_or(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_map_atomic_or(spacename, key, predicates, mapattributes).waitForIt();
    }

    public native Deferred async_map_atomic_xor(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean map_atomic_xor(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_map_atomic_xor(spacename, key, mapattributes).waitForIt();
    }

    public native Deferred async_cond_map_atomic_xor(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean cond_map_atomic_xor(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_map_atomic_xor(spacename, key, predicates, mapattributes).waitForIt();
    }

    public native Deferred async_map_string_prepend(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean map_string_prepend(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_map_string_prepend(spacename, key, mapattributes).waitForIt();
    }

    public native Deferred async_cond_map_string_prepend(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean cond_map_string_prepend(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_map_string_prepend(spacename, key, predicates, mapattributes).waitForIt();
    }

    public native Deferred async_map_string_append(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean map_string_append(String spacename, Object key, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_map_string_append(spacename, key, mapattributes).waitForIt();
    }

    public native Deferred async_cond_map_string_append(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException;
    public Boolean cond_map_string_append(String spacename, Object key, Map<String, Object> predicates, Map<String, Map<Object, Object>> mapattributes) throws HyperDexClientException
    {
        return (Boolean) async_cond_map_string_append(spacename, key, predicates, mapattributes).waitForIt();
    }

    public native Iterator search(String spacename, Map<String, Object> predicates);

    public native Deferred async_search_describe(String spacename, Map<String, Object> predicates) throws HyperDexClientException;
    public String search_describe(String spacename, Map<String, Object> predicates) throws HyperDexClientException
    {
        return (String) async_search_describe(spacename, predicates).waitForIt();
    }

    public native Iterator sorted_search(String spacename, Map<String, Object> predicates, String sortby, int limit, boolean maxmin);

    public native Deferred async_group_del(String spacename, Map<String, Object> predicates) throws HyperDexClientException;
    public Boolean group_del(String spacename, Map<String, Object> predicates) throws HyperDexClientException
    {
        return (Boolean) async_group_del(spacename, predicates).waitForIt();
    }

    public native Deferred async_count(String spacename, Map<String, Object> predicates) throws HyperDexClientException;
    public Long count(String spacename, Map<String, Object> predicates) throws HyperDexClientException
    {
        return (Long) async_count(spacename, predicates).waitForIt();
    }
}
